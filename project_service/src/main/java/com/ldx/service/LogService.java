package com.ldx.service;

import com.github.pagehelper.PageInfo;
import com.ldx.domain.export.Log;
import com.ldx.domain.export.LogExample;


public interface LogService {
    PageInfo<Log> findByPageHelper(LogExample logExample, int page, int size);

    void save(Log log);
}
