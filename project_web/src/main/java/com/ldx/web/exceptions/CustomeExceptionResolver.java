package com.ldx.web.exceptions;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//异常解析器
@Component
public class CustomeExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //创建返回值对象
        ModelAndView modelAndView = new ModelAndView();
        //设置响应视图
        modelAndView.setViewName("error");
        //判断异常 CustomeException为业务异常 返回给客户
        if (e instanceof CustomeException) {
            modelAndView.addObject("errorMsg",e);
        }else {
            //系统异常
            modelAndView.addObject("errorMsg","服务器异常");
            e.printStackTrace();
        }
        return modelAndView;
    }
}
