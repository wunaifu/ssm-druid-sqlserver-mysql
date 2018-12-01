package com.wnf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wnf.dao.TestUserDao;

import com.wnf.entity.TestUser;
import com.wnf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wunaifu on 2018/7/28.
 */
@Service
public class UserServiceImpl implements UserService {

    //注入Dao实现类依赖
    //    @Resource
    @Autowired
    private TestUserDao userDao;


    public List<TestUser> userList() {
        List<TestUser> userList = userDao.queryAll();
        return userList;
    }


}
