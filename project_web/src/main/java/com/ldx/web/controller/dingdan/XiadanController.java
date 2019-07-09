package com.ldx.web.controller.dingdan;


import com.ldx.dao.export.invoiceDao;
import com.ldx.domain.export.User;
import com.ldx.domain.export.invoice;
import com.ldx.utils.UtilFuns;
import com.ldx.web.controller.system.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;


@Controller
@RequestMapping("/xiadan")
public class XiadanController extends BaseController {

    @Autowired
    private invoiceDao invoiceDao;



    @RequestMapping("/add")
    public String add() {
        return "dingdan/add";
    }



    @RequestMapping(value = "/adddingdan",name = "添加订单")
    public String adddingdan(invoice invoice){
        //添加发票
        invoice.setInvoiceId(UtilFuns.getUUID());
        invoice.setDate(new Date().toString());
        User user = (User)session.getAttribute("user");
        String companyId = user.getCompanyId();
        invoice.setFromCompany(user.getCompanyName());
        invoice.setRemark(user.getCompanyName()+" "+invoice.getCountry()+" "+invoice.getInvoiceRemark()+"箱"+invoice.getFbaId()+" ");
        invoiceDao.insertSelective(invoice);

        return "home/home";
    }
}
