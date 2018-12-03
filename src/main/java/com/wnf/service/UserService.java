package com.wnf.service;


import com.github.pagehelper.PageInfo;
import com.wnf.entity.TestUser;
import com.wnf.entity.User;

import java.util.List;

/**
 * Created by wunaifu on 2018/7/28.
 * 定义方法，只需要定义，实现在对应的*ServiceImpl.java里实现，这就是spring做的工作
 */
public interface UserService {

    String addUser(User user);
    List<User> userList2();
    PageInfo userListPager(int page, int rows);
    List<User> userList2(int pageNo, int pageSize, int startRow);
}