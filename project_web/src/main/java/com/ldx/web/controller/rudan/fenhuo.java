package com.ldx.web.controller.rudan;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldx.dao.export.serviceDao;
import com.ldx.domain.export.invoice;
import com.ldx.domain.export.invoiceExample;
import com.ldx.domain.export.service;
import com.ldx.domain.export.serviceExample;
import com.ldx.web.controller.system.BaseController;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/rudan/fenhuo")
@Transactional
public class fenhuo extends BaseController {



    @Autowired
    private com.ldx.dao.export.invoiceDao invoiceDao;

    @Autowired
    private com.ldx.dao.export.serviceDao serviceDao;


    @RequestMapping("/work")
    public String work(String invoiceId,String serviceid){
        invoice invoice = new invoice();
        invoice.setInvoiceId(invoiceId);
        invoice.setServiceId(serviceid);
        invoiceDao.updateByPrimaryKeySelective(invoice);
        return "redirect:/rudan/fenhuo/list.do";

    }




    @RequestMapping("/list")
    public String list(@Param("query") String query, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "15") int size){


        invoiceExample invoiceExample = new invoiceExample();
        com.ldx.domain.export.invoiceExample.Criteria criteria = invoiceExample.createCriteria();
        criteria.andOuthomeConweight2IsNotNull()
                .andOuthomeConvol5IsNotNull()
                .andOuthomeConvol6IsNotNull()
                .andServiceIdIsNull();
        if (!StringUtils.isEmpty(query)) {
            //入仓数据(总重量 总体积)是空或者null
            criteria.andFbaIdLike("%"+query+"%");

        }
        invoiceExample.setOrderByClause("`date` DESC");

        PageHelper.startPage(page,size);
        List<invoice> invoices = invoiceDao.selectByExample(invoiceExample);
        PageInfo<invoice> invoicePageInfo = new PageInfo<>(invoices);


        //查询渠道
        List<service> services = serviceDao.selectByExample(new serviceExample());

        session.setAttribute("",invoicePageInfo);
        request.setAttribute("page",invoicePageInfo);
        request.setAttribute("query",query);
        request.setAttribute("service",services);

        return "rudan/fenhuo-list";
    }

}
