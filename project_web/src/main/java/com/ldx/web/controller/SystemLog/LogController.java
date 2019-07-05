package com.ldx.web.controller.SystemLog;

import com.github.pagehelper.PageInfo;
import com.ldx.domain.export.LogExample;
import com.ldx.service.LogService;
import com.ldx.web.controller.system.BaseController;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/system/log")
public class LogController extends BaseController {
        @Autowired
    private LogService logService;

    @RequestMapping("/list")
    public String list(@Param("query") String query, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5")int size){
        LogExample logExample = new LogExample();
        if (!StringUtils.isEmpty(query)) {
            logExample.createCriteria().andUserNameLike("%"+query+"%");
        }
        PageInfo info = logService.findByPageHelper(logExample,page,size);
        request.setAttribute("page",info);
        return "system/log/log-list";
    }

}
