package com.ldx.service.Impl;

import com.github.pagehelper.PageInfo;
import com.ldx.domain.export.service;
import com.ldx.domain.export.serviceExample;
import com.ldx.service.ServerServer;

import java.util.List;

public class ServerServerImpl implements ServerServer {
    @Override
    public PageInfo findByPageHelper(serviceExample serviceExample, int page, int size) {
        return null;
    }

    @Override
    public List<service> findAll(serviceExample companyExample) {
        return null;
    }

    @Override
    public service findById(String id) {
        return null;
    }

    @Override
    public boolean save(service company) {
        return false;
    }

    @Override
    public boolean delete(String companyId) {
        return false;
    }

    @Override
    public boolean update(service company) {
        return false;
    }
}
