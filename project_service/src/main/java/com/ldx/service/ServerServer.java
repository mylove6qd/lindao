package com.ldx.service;


import com.github.pagehelper.PageInfo;
import com.ldx.domain.export.service;
import com.ldx.domain.export.serviceExample;

import java.util.List;

public interface ServerServer {
    //按分页查
    PageInfo findByPageHelper(serviceExample serviceExample, int page, int size);
    //查询所有
    List<service> findAll(serviceExample companyExample);
    //根据id查
    service findById(String id);


    boolean save(service company);

    boolean delete(String companyId);

    boolean update(service company);
}
