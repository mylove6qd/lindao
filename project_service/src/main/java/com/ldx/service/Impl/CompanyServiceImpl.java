package com.ldx.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldx.dao.export.CompanyDao;
import com.ldx.domain.export.Company;
import com.ldx.domain.export.CompanyExample;
import com.ldx.service.CompanyService;
import com.ldx.utils.UtilFuns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDao companyDao;



    @Override
    public PageInfo findByPageHelper(CompanyExample companyExample, int page, int size) {
        PageHelper.startPage(page,size);
        List<Company> companies = companyDao.selectByExample(companyExample);
        PageInfo<Company> companyPageInfo = new PageInfo<>(companies);
        return companyPageInfo;
    }

    @Override
    public List<Company> findAll(CompanyExample companyExample) {
        List<Company> companies = companyDao.selectByExample(companyExample);
        return companies;
    }

    @Override
    public Company findById(String id) {
        Company company = companyDao.selectByPrimaryKey(id);
        return company;
    }

    @Override
    public boolean save(Company company) {
        try{
            company.setCompanyId(UtilFuns.getUUID());
            companyDao.insert(company);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean delete(String companyId) {

        try{
            companyDao.deleteByPrimaryKey(companyId);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Company company) {

        try{
            companyDao.updateByPrimaryKeySelective(company);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
}
