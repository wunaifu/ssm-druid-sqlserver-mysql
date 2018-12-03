package com.wnf.service.impl;

import com.wnf.dao.TestUserDao;
import com.wnf.datasource.DynamicDataSourceHolder;
import com.wnf.entity.TestUser;
import com.wnf.service.SqlServerTestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SqlServerTestUserServiceImpl implements SqlServerTestUserService {

//    提示：注解@DataSource既可以加在方法上，也可以加在接口或者接口的实现类上，
//    优先级别：方法>实现类>接口。也就是说如果接口、接口实现类以及方法上分别加了
//    @DataSource注解来指定数据源，则优先以方法上指定的为准。

    @Autowired
    private TestUserDao testUserDao;

    public List<TestUser> userList() {
        // 手动指定切换到数据源，切换到SQLServer数据库
        DynamicDataSourceHolder.setDataSource("dataSource1");
        List<TestUser> userList = testUserDao.queryAll();
        return userList;
    }
}