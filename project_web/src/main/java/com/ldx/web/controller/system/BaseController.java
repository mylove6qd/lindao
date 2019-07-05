package com.ldx.web.controller.system;


import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BaseController {

    @Autowired
    protected HttpServletRequest request;//Autowired注解是从线程上获取的请求对象

    @Autowired
    protected HttpSession session;

    @Autowired
    protected HttpServletResponse response;

//    protected User getCurrentUser(){
//        return (User) session.getAttribute("user");
//    }


//    protected String getCurrentUserCompanyId(){
//        User user = (User) session.getAttribute("user");
//        if(user!=null){
//            return user.getCompanyId();
//        }
//        return "";
//    }

//    protected String getCurrentUserCompanyName(){
//        User user = (User) session.getAttribute("user");
//        if(user!=null){
//            return user.getCompanyName();
//        }
//        return "";
//    }
//



    /**
     * ModelAttribute注解表示在控制器方法执行之前都会先执行此方法
     * @param request
     * @param response
     * @param session
     */
//    @ModelAttribute
//    public void setReqAndResp(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
//        this.request = request;
//        this.response = response;
//        this.session = session;
//        System.out.println(request);
//        //模拟数据
//	    //user = (User)session.getAttribute("loginUser");
//	    //if(user != null) {
//		//    this.companyId = user.getCompanyId();
//		//    this.companyName=user.getCompanyName();
//	    //}
//    }
}
