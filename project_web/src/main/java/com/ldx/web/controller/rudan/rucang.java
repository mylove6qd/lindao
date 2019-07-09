package com.ldx.web.controller.rudan;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldx.dao.export.invoiceDao;
import com.ldx.domain.export.invoice;
import com.ldx.domain.export.invoiceExample;
import com.ldx.web.controller.system.BaseController;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/rudan/rucang")
public class rucang extends BaseController {

    @Autowired
    private invoiceDao invoiceDao;



    //给入单输入入仓尺寸的页面
    @RequestMapping("/update")
    public String update(String id){

        return "rudan/rudan-list";
    }




    @RequestMapping("/list")
    public String list(@Param("query") String query, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "15") int size){


        invoiceExample invoiceExample = new invoiceExample();
        if (!StringUtils.isEmpty(query)) {
            invoiceExample.createCriteria().andFbaIdLike("%"+query+"%");
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
