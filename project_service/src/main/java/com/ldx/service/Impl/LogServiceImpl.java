package com.ldx.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldx.dao.export.LogDao;
import com.ldx.domain.export.Log;
import com.ldx.domain.export.LogExample;
import com.ldx.service.LogService;
import com.ldx.utils.UtilFuns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao logDao;


    @Override
    public PageInfo<Log> findByPageHelper(LogExample logExample, int page, int size) {
        PageHelper.startPage(page, size);
        logExample.setOrderByClause("`time` DESC");
        List<Log> logs = logDao.selectByExample(logExample);
        PageInfo<Log> logPageInfo = new PageInfo<>(logs);
        return logPageInfo;
    }

    @Override
    public void save(Log log) {
        log.setId(UtilFuns.getUUID());
        logDao.insert(log);
    }
}
