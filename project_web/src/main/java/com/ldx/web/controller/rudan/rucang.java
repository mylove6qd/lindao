package com.ldx.web.controller.rudan;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldx.dao.export.boxDao;
import com.ldx.dao.export.invoiceDao;
import com.ldx.domain.export.box;
import com.ldx.domain.export.boxExample;
import com.ldx.domain.export.invoice;
import com.ldx.domain.export.invoiceExample;
import com.ldx.web.controller.system.BaseController;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/rudan/rucang")
@Transactional
public class rucang extends BaseController {

    @Autowired
    private invoiceDao invoiceDao;

    @Autowired
    private boxDao boxDao;


    //保存入仓数据
    @RequestMapping("/adddate")
    public String adddate(box box){

        List<box> boxes = new ArrayList<>();
        String fbaId = box.getFbaId();
        String outsideId = box.getOutsideId();
        String inhomeWeight = box.getInhomeWeight();
        String inhomeX = box.getInhomeX();
        String inhomeY = box.getInhomeY();
        String inhomeZ = box.getInhomeZ();



        if (fbaId.contains(",")||
                outsideId.contains(",")||
                inhomeWeight.contains(",")||
                inhomeX.contains(",")||
                inhomeY.contains(",")||
                inhomeZ.contains(",")) {
            String[] fbaIdsplit = fbaId.split(",");
            String[] outsideIdsplit = outsideId.split(",");
            String[] inhomeWeightsplit = inhomeWeight.split(",");
            String[] inhomeXsplit = inhomeX.split(",");
            String[] inhomeYsplit = inhomeY.split(",");
            String[] inhomeZsplit = inhomeZ.split(",");

            for (int i=0;i<fbaIdsplit.length;i++) {
                box box1 = new box();
                box1.setFbaId(fbaIdsplit[i]);
                box1.setOutsideId(outsideIdsplit[i]);
                box1.setInhomeWeight(inhomeWeightsplit[i]);
                box1.setInhomeX(inhomeXsplit[i]);
                box1.setInhomeY(inhomeYsplit[i]);
                box1.setInhomeZ(inhomeZsplit[i]);
                boxes.add(box1);
            }

        }else {
            boxes.add(box);
        }
        //入仓重量 体积
        double inw = 0;
        double in5 = 0;
        double in6 = 0;
        for (box box1 : boxes) {
            //计算入仓总重量 体积
            inw += Double.parseDouble(box1.getInhomeWeight());

            double v = Double.parseDouble(box1.getInhomeX())*
                    Double.parseDouble(box1.getInhomeY())*
                    Double.parseDouble(box1.getInhomeZ());

            in5 += v/5000;
            in6 += v/6000;

            boxDao.updateByPrimaryKeySelective(box1);
        }

        String fbaId1 = boxes.get(0).getFbaId();

        com.ldx.domain.export.box box2 = boxDao.selectByPrimaryKey(fbaId1);

        String invid = box2.getInvoiceId();

        String invId = invoiceDao.selectByPrimaryKey(invid).getInvoiceId();

        invoice invoice = new invoice();

        invoice.setInvoiceId(invId);
        invoice.setInhomeConweight(new Double(inw).toString());
        invoice.setInhomeConvol5(new Double(in5).toString());
        invoice.setInhomeConvol6(new Double(in6).toString());

        //修改发票表
        invoiceDao.updateByPrimaryKeySelective(invoice);

        return "redirect:/rudan/rucang/list.do";
    }




    //给入单输入入仓尺寸的页面
    @RequestMapping("/update")
    public String update(String id){
        //发票id
        boxExample boxExample = new boxExample();
        boxExample.createCriteria().andInvoiceIdEqualTo(id);
        boxExample.setOrderByClause("`outside_id`+0");

        List<box> boxes = boxDao.selectByExample(boxExample);
        request.setAttribute("list",boxes);
        request.setAttribute("id",invoiceDao.selectByPrimaryKey(id).getFbaId());
        return "rudan/rudan-updatebox";
    }




    @RequestMapping("/list")
    public String list(@Param("query") String query, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "15") int size){


        invoiceExample invoiceExample = new invoiceExample();
        com.ldx.domain.export.invoiceExample.Criteria criteria = invoiceExample.createCriteria();
        criteria.andInhomeConweightIsNull()
                .andInhomeConvol5IsNull()
                .andInhomeConvol6IsNull();
        if (!StringUtils.isEmpty(query)) {
            //入仓数据(总重量 总体积)是空或者null
            criteria.andFbaIdLike("%"+query+"%");

        }
        invoiceExample.setOrderByClause("`date` DESC");

        PageHelper.startPage(page,size);
        List<invoice> invoices = invoiceDao.selectByExample(invoiceExample);
        PageInfo<invoice> invoicePageInfo = new PageInfo<>(invoices);

        session.setAttribute("",invoicePageInfo);
        request.setAttribute("page",invoicePageInfo);
        request.setAttribute("query",query);

        return "rudan/rudan-list";
    }
}
