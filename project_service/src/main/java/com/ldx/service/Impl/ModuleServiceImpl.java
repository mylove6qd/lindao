package com.ldx.service.Impl;

import com.ldx.dao.export.ModuleDao;
import com.ldx.dao.export.UserDao;
import com.ldx.domain.export.Module;
import com.ldx.domain.export.ModuleExample;
import com.ldx.domain.export.User;
import com.ldx.domain.export.UserExample;
import com.ldx.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    private UserDao userdao;
    @Autowired
    private ModuleDao moduleDao;

    //根据用户查询用户对应的模块集合
    @Override
    public List<Module> findModuleByUser(User user) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserNameEqualTo(user.getUserName());
        List<User> users = userdao.selectByExample(userExample);

        if (users.size()!=1) {
            return null;
        }else {
            User user1 = null ;
            for (User user2 : users) {
                user1 = user2;
            }

            String position = "%"+user1.getPosition()+"%";

            ModuleExample moduleExample = new ModuleExample();
            moduleExample.createCriteria().andPositionLike(position);
            List<Module> modules = moduleDao.selectByExample(moduleExample);

            return modules;
        }



    }
}
