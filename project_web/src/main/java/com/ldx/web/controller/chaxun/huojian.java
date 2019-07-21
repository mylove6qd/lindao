package com.ldx.web.controller.chaxun;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldx.domain.export.User;
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

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

@Controller
@RequestMapping("/huojian/chaxun")
@Transactional
public class huojian extends BaseController {



    @Autowired
    private com.ldx.dao.export.invoiceDao invoiceDao;

    @Autowired
    private com.ldx.dao.export.serviceDao serviceDao;


    @RequestMapping("/work")
    public String work(String invoiceId,String serviceid){
//        invoice invoice = new invoice();
//        invoice.setInvoiceId(invoiceId);
//        invoice.setServiceId(serviceid);
//        invoiceDao.updateByPrimaryKeySelective(invoice);
        return "redirect:/huojian/chaxun/list.do";

    }




    @RequestMapping("/list")
    public String list(@Param("query") String query, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "15") int size) throws IOException {

        User user = (User) session.getAttribute("user");
        String companyName = user.getCompanyName();

        invoiceExample invoiceExample = new invoiceExample();
        com.ldx.domain.export.invoiceExample.Criteria criteria = invoiceExample.createCriteria();
        criteria.andFromCompanyEqualTo(companyName);
        if (!StringUtils.isEmpty(query)) {
            //入仓数据(总重量 总体积)是空或者null
            criteria.andFbaIdLike("%" + query + "%");

        } else {
            criteria.andQueryIdNotEqualTo("签收");

        }

        invoiceExample.setOrderByClause("`date` DESC");
        PageHelper.startPage(page, size);
        List<invoice> invoices = invoiceDao.selectByExample(invoiceExample);

        InputStream resourceAsStream = huojian.class.getClassLoader().getResourceAsStream("properties/wuliu.properties");

        Properties properties = new Properties();
        properties.load(resourceAsStream);

        for (invoice invoice : invoices) {
            String[] split = invoice.getQueryId().split("-");
            String head = properties.getProperty(split[0].toLowerCase() + "head");
            String tail = properties.getProperty(split[0].toLowerCase() + "tail");
            invoice.setLink(head+split[1]+tail);
        }

        PageInfo<invoice> invoicePageInfo = new PageInfo<>(invoices);

        session.setAttribute("", invoicePageInfo);
        request.setAttribute("page", invoicePageInfo);
        request.setAttribute("query", query);

        return "rudan/chanxun-list";
    }

}
