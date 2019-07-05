package com.ldx.service;


import com.github.pagehelper.PageInfo;
import com.ldx.domain.export.User;
import com.ldx.domain.export.UserExample;

import java.util.List;

public interface UserService {
    //那个公司的用户??? 应该不用? 对于所有用户的开放 都是本公司分配用户给客人使用的

    //按分页查
    PageInfo findByPageHelper(UserExample userExample, int page, int size);
    //查询所有
    List<User> findAll(UserExample userExample);
    //根据id查
    User findById(String id);


    boolean save(User user);

    boolean delete(String userId);

    boolean update(User user);


    User findByUserName(String username);
}
