package com.ldx.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldx.dao.export.CompanyDao;
import com.ldx.dao.export.UserDao;
import com.ldx.domain.export.Company;
import com.ldx.domain.export.CompanyExample;
import com.ldx.domain.export.User;
import com.ldx.domain.export.UserExample;
import com.ldx.service.UserService;
import com.ldx.utils.MD5Encrypt;
import com.ldx.utils.UtilFuns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private CompanyDao companyDao;

    @Override
    public PageInfo findByPageHelper(UserExample userExample, int page, int size) {
        PageHelper.startPage(page,size);
        List<User> users = userDao.selectByExample(userExample);
        //为每一个用户 通过公司id查找公司名称 并赋值给对象

        List<Company> companies = companyDao.selectCompanyId_Name_ByExample(new CompanyExample());

        for (User user : users) {
            String companyId = user.getCompanyId();
            String companyName = "";
            for (Company company : companies) {
                if (company.getCompanyId().equals(companyId)) {
                    companyName = company.getCompanyName();
                }
            }
            user.setCompanyName(companyName);
        }

        PageInfo<User> userPageInfo = new PageInfo<>(users);
        return userPageInfo;
    }

    @Override
    public List<User> findAll(UserExample userExample) {
        List<User> users = userDao.selectByExample(userExample);
        return users;
    }

    @Override
    public User findById(String id) {
        User user = userDao.selectByPrimaryKey(id);
        return user;
    }

    @Override
    public boolean save(User user) {

        try{
            user.setUserId(UtilFuns.getUUID());
            //使用用户名和密码登录    使用md5 用用户名和密码加密的到密码
            String md5 = MD5Encrypt.md5(user.getPassword(), user.getUserName());
            user.setPassword(md5);
            userDao.insert(user);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(String userId) {

        try{
            userDao.deleteByPrimaryKey(userId);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(User user) {

        try{

            //使用用户名和密码登录    使用md5 用用户名和密码加密的到密码
            String md5 = MD5Encrypt.md5(user.getPassword(), user.getUserName());
            user.setPassword(md5);

            userDao.updateByPrimaryKeySelective(user);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public User findByUserName(String username) {

        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserNameEqualTo(username);
        List<User> users = userDao.selectByExample(userExample);
        if (users.size()!=1) {
            return null;
        }else {
            User user1 = null ;
            for (User user : users) {
                user1 = user;
            }
            return user1;
        }

    }
}
