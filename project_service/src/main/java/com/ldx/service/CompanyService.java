package com.ldx.service;

import com.github.pagehelper.PageInfo;
import com.ldx.domain.export.Company;
import com.ldx.domain.export.CompanyExample;

import java.util.List;

public interface CompanyService {
    //按分页查
    PageInfo findByPageHelper(CompanyExample companyExample, int page, int size);
    //查询所有
    List<Company> findAll(CompanyExample companyExample);
    //根据id查
    Company findById(String id);


    boolean save(Company company);

    boolean delete(String companyId);

    boolean update(Company company);
}
