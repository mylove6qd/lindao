package com.ldx.web.controller.system;


import com.ldx.domain.export.Module;
import com.ldx.domain.export.User;
import com.ldx.service.ModuleService;
import com.ldx.utils.UtilFuns;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class LoginController extends BaseController{


    @Autowired
    private ModuleService moduleService;


    @RequestMapping("/login")
    public String login(String email,String password) {
        //判断当前用户是否已经登录了
        User user = (User) session.getAttribute("user");
        if(user != null){
            return "home/main";
        }
        //1.判断email是否有值，如果没值的话，直接前往登录页面
        if(UtilFuns.isEmpty(email)){
            return "redirect:/login.jsp";
        }
        try {
            //2.获取到Subject
            Subject subject = SecurityUtils.getSubject();
            //3.创建带有用户名和密码的令牌
            UsernamePasswordToken token = new UsernamePasswordToken(email, password);
            //4.使用subject的login方法实现登录
            subject.login(token);//========================>需要有真正的去数据库查询用户，和密码比较的操作。此方法就要访问Realm的信息,Realm我们自己写
            //5.取出当前登录用户的信息
            user = (User) subject.getPrincipal();

            //6.登录成功，存入会话域中
            session.setAttribute("user", user);
            //7.获取当前登录用户的菜单
            List<Module> moduleList = moduleService.findModuleByUser(user);
            System.out.println(moduleList);
            //8.把查询出来的模块列表存入session域中
            session.setAttribute("modules", moduleList);
            //9.前往主页面
            return "home/main";// /WEB-INF/pages/home/main.jsp
        }
        catch (Exception e){
            //当shiro登录失败是会抛出异常
            e.printStackTrace();
            request.setAttribute("error","用户名或密码错误");
            //重新前往登录页面
            return "forward:/login.jsp";
        }
    }

    @RequestMapping("/loginVue")
    public @ResponseBody
    String loginVue(@RequestBody User userP) {
//
//        //判断当前用户是否已经登录了
//        User user = (User) session.getAttribute("user");
//        if(user != null){
//            return "{\"status1\":\"0\"}";
//        }


        //1.判断用户名是否有值，如果没值的话，直接前往登录页面
        if(UtilFuns.isEmpty(userP.getUserName())){
            return "{\"status1\":\"-1\"}";
        }
        try {
            //2.获取到Subject
            Subject subject = SecurityUtils.getSubject();
            //3.创建带有用户名和密码的令牌
            UsernamePasswordToken token = new UsernamePasswordToken(userP.getUserName(), userP.getPassword());
            //4.使用subject的login方法实现登录
            subject.login(token);//========================>需要有真正的去数据库查询用户，和密码比较的操作。此方法就要访问Realm的信息,Realm我们自己写
            //5.取出当前登录用户的信息
            userP = (User) subject.getPrincipal();

            //6.登录成功，存入会话域中
            session.setAttribute("user", userP);
           // 7.获取当前登录用户的菜单
            List<Module> moduleList = moduleService.findModuleByUser(userP);
            System.out.println(moduleList);
          //  8.把查询出来的模块列表存入session域中
            session.setAttribute("modules", moduleList);
        //    9.前往主页面
            return "{\"status1\":\"0\"}";// /WEB-INF/pages/home/main.jsp
        }
        catch (Exception e){
            //当shiro登录失败是会抛出异常
            e.printStackTrace();
            request.setAttribute("error","用户名或密码错误");
            //重新前往登录页面
            return "{\"status1\":\"-1\"}";
        }
    }

    //退出
    @RequestMapping(value = "/logout",name="用户登出")
    public String logout(){
        //SecurityUtils.getSubject().logout();   //登出
        return "forward:login.jsp";
    }

    @RequestMapping("/home")
    public String home(){
        return "home/home";
    }


    //把页面放在webinf为了让用户不不要直接在地址栏访问jsp,是以安全做法.
    //但是js又想区调区这个页面,只能在服务求端去跳转所以.你必须在controller去跳转
    //然后js就去跳转controller指定的地址.
    @RequestMapping(value = "/home/main",name="用户登入")
    public String homemain(){
        return "home/main";
    }
}
