package com.wnf.dao;


import com.wnf.entity.Sqlserveruser;
import com.wnf.entity.TestUser;

import java.util.List;

/**
 * Created by xwy_brh on 2017/9/1.
 */
public interface TestUserDao {

    List<TestUser> queryAll();

    int insert(Sqlserveruser record);


}
