package com.ldx.web.controller.company;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.ldx.domain.export.Company;
import com.ldx.domain.export.CompanyExample;
import com.ldx.service.CompanyService;
import com.ldx.web.controller.system.BaseController;
import com.ldx.web.exceptions.CustomeException;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/company")
public class CompanyContraller extends BaseController {
    @Autowired
    private CompanyService companyService ;
    /**
     * 获取企业列表
     * @return
     */
//    @RequestMapping("/list")
//    public String list(HttpServletRequest request){
//
//        //调用业务层查询
//        List<Company> all = companyService.findAll();
//        //2.存入请求域中
//        request.setAttribute("list",all);
//        //3.转发到列表页面
//        return "company/company-list";
//
//    }

    @RequestMapping("/list")
    public String list(@Param("query") String query, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size){

        CompanyExample companyExample = new CompanyExample();
        if (!StringUtils.isEmpty(query)) {
            companyExample.createCriteria().andCompanyNameLike("%"+query+"%");
        }
        //调用业务层查询
        PageInfo byPageHelper = companyService.findByPageHelper(companyExample,page, size);

        //2.存入请求域中
        request.setAttribute("page",byPageHelper);
        request.setAttribute("query",query);
        //3.转发到列表页面
        return "company/company-list";

    }


    /**
     * 添加企业
     * @return
     */
    @RequestMapping("/toAdd")
    public String toAdd(){

        return "company/company-add";
    }

    @RequestMapping(value = "/edit",name = "操作公司")
    public String edit(Company company) throws CustomeException {



        //需要判断 如果id为null是添加
        //id不为null是修改
        //isEmpty是否为空
        if (StringUtil.isEmpty(company.getCompanyId())) {
            //添加
            String companyName = company.getCompanyName();
            CompanyExample companyExample = new CompanyExample();
            companyExample.createCriteria().andCompanyNameEqualTo(companyName);
            List<Company> all = companyService.findAll(companyExample);
            if (all.size()!=0) {
                throw new CustomeException("公司名重复");
            }

            companyService.save(company);
        }else{


            String companyName = company.getCompanyName();
            CompanyExample companyExample = new CompanyExample();
            companyExample.createCriteria().andCompanyNameEqualTo(companyName);
            List<Company> all = companyService.findAll(companyExample);
            if (all.size()!=0) {
                Company company1 = all.get(0);
                if ((company1.getCompanyId()).equals(company.getCompanyId())) {

                }else {
                    throw new CustomeException("公司名重复");
                }
            }



            //修改
            companyService.update(company);
        }
        return "redirect:/company/list.do";//必须写！原因：重定向是两次请求，是浏览器行为。就相当于在浏览器上输入访问地址
    }


    //处理修改 拿到传过来的id 然后封装成company 通过请求转发 发给company-update.jsp回显
    @RequestMapping(value = "/toUpdate")
public String toUpdate(String id,HttpServletRequest request){
        Company byId = companyService.findById(id);
        request.setAttribute("company",byId);
        return "company/company-update";
}

@RequestMapping(value = "/delete",name = "删除公司")
    public String delete(String id){
        companyService.delete(id);
    return "redirect:/company/list.do";
}



}
