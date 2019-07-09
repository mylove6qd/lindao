package com.ldx.web.controller.user;

import com.github.pagehelper.PageInfo;
import com.ldx.domain.export.Company;
import com.ldx.domain.export.CompanyExample;
import com.ldx.domain.export.User;
import com.ldx.domain.export.UserExample;
import com.ldx.service.CompanyService;
import com.ldx.service.UserService;
import com.ldx.utils.UtilFuns;
import com.ldx.web.controller.system.BaseController;
import com.ldx.web.exceptions.CustomeException;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/system/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private CompanyService companyService;

    //只有本公司才有权利产看用户
    //其他公司的不需要管理用户
    @RequestMapping("/list")
    public String list(@Param("query") String query, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size){

        UserExample userExample = new UserExample();
        if (!StringUtils.isEmpty(query)) {
            userExample.createCriteria().andUserNameLike("%"+query+"%");
        }
        //调用业务层查询

        //2.调用service查询
        //没有查询条件
        PageInfo pageInfo = userService.findByPageHelper(userExample,page,size);
        //3.存入请求域中
        request.setAttribute("page",pageInfo);
        request.setAttribute("query",query);
        //4.返回
        return "system/user/user-list";
    }

    ////////////////////////////////////////////////////////////////////////////////
    /**
     * 前往添加页面
     * @return
     */
    @RequestMapping("/toAdd")
    public String toAdd(){
        //需要设置用户所在的公司
        //查询所有公司回显
        List<Company> companyList = companyService.findAll(new CompanyExample());

       request.setAttribute("companyList",companyList);
        return "system/user/user-add";
    }



    @RequestMapping(value = "/goto1",name = "用户修改密码")
    public String goto1(String id){
        //1.根据id查询用户
        User user = userService.findById(id);
        //2.把查出来的用户存入请求域
        request.setAttribute("user",user);
        //5.前往编辑页面
        return "system/user/user-password";

    }




    @RequestMapping(value = "/editpass",name = "用户修改")
    public String editpass(User user) throws CustomeException {




            //更新

            userService.update(user);
        //2.重定向到列表页面
        return "home/main";
    }






    @RequestMapping(value = "/edit",name = "操作用户")
    public String edit(User user) throws CustomeException {



        //1.判断是保存还是更新
        if(UtilFuns.isEmpty(user.getUserId())){
            String userName = user.getUserName();
            UserExample userExample = new UserExample();
            userExample.createCriteria().andUserNameEqualTo(userName);
            List<User> users = userService.findAll(userExample);
            if (users.size()!=0) {
                throw new CustomeException("用户名重复");
            }

            //保存
            userService.save(user);
        }else {
            //更新


                String userName = user.getUserName();
                UserExample userExample = new UserExample();
                userExample.createCriteria().andUserNameEqualTo(userName);
                List<User> users = userService.findAll(userExample);
                if (users.size() != 0) {
                    User user1 = users.get(0);
                    if ((user1.getUserId()).equals(user.getUserId())) {

                    }else{
                    throw new CustomeException("用户名重复");
                    }
                }


                userService.update(user);

       }
        //2.重定向到列表页面
        return "redirect:/system/user/list.do";
    }

    /**
     * 前往更新页面
     * @param id
     * @return
     */
    @RequestMapping("/toUpdate")
    public String toUpdate(String id){
        //1.根据id查询用户
        User user = userService.findById(id);
        //2.把查出来的用户存入请求域
        request.setAttribute("user",user);

        //查询所有公司
        List<Company> all = companyService.findAll(new CompanyExample());
        request.setAttribute("companyList",all);
        //5.前往编辑页面
        return "system/user/user-update";
    }

    /**
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete",name = "删除用户")
    public String delete(String id){
       userService.delete(id);
        return "redirect:/system/user/list.do";
    }





}


