package com.wnf.service;

import com.github.pagehelper.PageInfo;
import com.wnf.entity.Sqlserveruser;
import com.wnf.entity.TestUser;

import java.util.List;

public interface SqlServerTestUserService {
    List<TestUser> userList();
    List<Sqlserveruser> userListP();
}
