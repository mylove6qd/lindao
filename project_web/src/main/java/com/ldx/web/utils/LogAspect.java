package com.ldx.web.utils;

import com.ldx.domain.export.Log;
import com.ldx.domain.export.User;
import com.ldx.service.LogService;
import com.ldx.web.exceptions.CustomeException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 系统日志的切面类
 * @author 黑马程序员
 * @Company http://www.think.com
 */
@Component
@Aspect
public class LogAspect {

    @Autowired
    private HttpServletRequest request;//用到用户信息，可以通过request的getSession获取

    @Autowired
    private LogService logService;

    /**
     * 环绕通知记录日志
     * @return
     * ProceedingJoinPoint 它就相当于 method
     */
    @Around("execution(* com.ldx.web.controller.*.*.*(..))")
    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
       //1.获取当前登录的用户
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        //2.判断用户是否登录了
        if(user != null){
            //1.从pjp中获取方法签名
            Signature signature = pjp.getSignature();
            //2.判断是不是方法签名
            if(signature instanceof MethodSignature){
                //强转
                MethodSignature methodSignature = (MethodSignature)signature;
                //3.获取当前执行的方法
                Method method = methodSignature.getMethod();
                //4.判断当前方法上是否有RequestMapping注解
                boolean hasAnnotated = method.isAnnotationPresent(RequestMapping.class);
                if(hasAnnotated) {
                    //5.取出注解
                    RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
                    //6.得到注解的属性，用于填充SysLog对象
//                String[] value = requestMapping.value();
//                StringBuilder ss = new StringBuilder();
//                if(value.length>1){
//                    for(String path : value){
//                        ss.append(path).append(",");
//                    }
//                }else{
//                    ss.append(value);
//                }



                        //拿到注解的name属性 通过name属性 知道用户做了什么操作
                        String name = requestMapping.name();
                    if (name.equals("")) {

                    }else {
                        //7.创建日志对象
                        Log sysLog = new Log();
                        sysLog.setIp(request.getRemoteAddr());//获取来访者ip
                        sysLog.setTime(new Date());//当前系统时间
                        sysLog.setMethod(method.getName());// 当前执行的方法
                        sysLog.setAction(name);//当前执行方法的说明
                        sysLog.setUserName(user.getUserName());
                        sysLog.setCompanyId(user.getCompanyId());
                        sysLog.setCompanyName(user.getCompanyName());
                        //8.保存日志
                        logService.save(sysLog);
                    }
                }
            }
        }

        //获取执行方法所需的参数
        Object[] args = pjp.getArgs();
        //定义返回值
        Object rtValue = null;
       // try{
            //切入点方法的执行
            rtValue = pjp.proceed(args);
        //}
//        catch (Throwable tl){
//            tl.printStackTrace();
//        }
        //不处理异常 抛出 交给spring的HandlerExceptionResolver 去处理异常
        return rtValue;
    }
}
