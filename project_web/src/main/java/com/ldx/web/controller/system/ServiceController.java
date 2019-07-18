package com.ldx.web.controller.system;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldx.dao.export.serviceDao;
import com.ldx.domain.export.Company;
import com.ldx.domain.export.CompanyExample;
import com.ldx.domain.export.service;
import com.ldx.domain.export.serviceExample;
import com.ldx.service.CompanyService;
import com.ldx.utils.UtilFuns;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/system/service")
public class ServiceController extends BaseController{

    @Autowired
    private CompanyService companyService;
    @Autowired
    private serviceDao serviceDao;


    @RequestMapping(value = "/edit",name="修改服务")
    public String edit(String id,service service){


        if (id==null){
        //添加
            service.setServiceId(UtilFuns.getUUID());
            serviceDao.insert(service);
        }else {
            serviceDao.updateByPrimaryKey(service);
        }

        return "redirect:/system/service/list.do";
    }

    @RequestMapping(value = "/delete",name = "删除服务")
    public String delete(String id){
        serviceDao.deleteByPrimaryKey(id);

        return "redirect:/system/service/list.do";
    }



    //处理修改 拿到传过来的id 然后封装成company 通过请求转发 发给company-update.jsp回显
    @RequestMapping(value = "/toUpdate")
    public String toUpdate(String id, HttpServletRequest request){

        CompanyExample companyExample = new CompanyExample();
        companyExample.createCriteria().andCompanyTypeEqualTo("渠道公司");
        List<Company> all = companyService.findAll(companyExample);

        if (id==null){

        }else {
            service service = serviceDao.selectByPrimaryKey(id);

            service.setServiceName(companyService.findById(service.getCompanyId()).getCompanyName());

            request.setAttribute("service", service);
        }
        request.setAttribute("company",all);
        return "company/company-service";
    }



    @RequestMapping("/list")
    public String list(@Param("query") String query, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size) {

        serviceExample serviceExample = new serviceExample();
        if (!StringUtils.isEmpty(query)) {
            CompanyExample companyExample = new CompanyExample();
            companyExample.createCriteria().andCompanyNameLike("%" + query + "%");
            List<Company> all = companyService.findAll(companyExample);
            if (all != null && all.size() > 0) {
                serviceExample.createCriteria().andCompanyIdEqualTo(all.get(0).getCompanyId());

                PageHelper.startPage(page, size);
                List<service> services = serviceDao.selectByExample(serviceExample);
                for (service service : services) {
                    service.setServiceName(companyService.findById(service.getCompanyId()).getCompanyName());
                }
                //调用业务层查询
                PageInfo byPageHelper = new PageInfo(services);
                //2.存入请求域中
                request.setAttribute("page", byPageHelper);
                request.setAttribute("query", query);
                //3.转发到列表页面
                return "company/service-list";

            } else {
                return "company/service-list";
            }

        }else {
            PageHelper.startPage(page, size);
            List<service> services = serviceDao.selectByExample(serviceExample);
            for (service service : services) {
                service.setServiceName(companyService.findById(service.getCompanyId()).getCompanyName());
            }
            //调用业务层查询
            PageInfo byPageHelper = new PageInfo(services);
            //2.存入请求域中
            request.setAttribute("page", byPageHelper);
            request.setAttribute("query", query);
            //3.转发到列表页面
            return "company/service-list";
        }
    }
}
