package com.ldx.web.controller.system;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldx.dao.export.serviceDao;
import com.ldx.domain.export.Company;
import com.ldx.domain.export.CompanyExample;
import com.ldx.domain.export.service;
import com.ldx.domain.export.serviceExample;
import com.ldx.service.CompanyService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/system/service")
public class ServiceController extends BaseController{

    @Autowired
    private CompanyService companyService;
    @Autowired
    private serviceDao serviceDao;


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
