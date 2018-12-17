package com.wnf.service;

import com.github.pagehelper.PageInfo;
import com.wnf.entity.Sqlserveruser;
import com.wnf.entity.TestUser;
import com.wnf.entity.User;

import java.util.List;

public interface SqlServerTestUserService {
    String addTestTransactional(User user);
    String delTestTransactional(int id);
    String updateTestTransactional(int id);
    List<TestUser> userList();
    List<Sqlserveruser> userListP();

    int test();
}
