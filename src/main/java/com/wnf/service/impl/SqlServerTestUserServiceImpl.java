package com.wnf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wnf.dao.SqlserveruserDao;
import com.wnf.dao.TestUserDao;
import com.wnf.datasource.DynamicDataSourceHolder;
import com.wnf.entity.Sqlserveruser;
import com.wnf.entity.SqlserveruserExample;
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
    @Autowired
    private SqlserveruserDao sqlserveruserDao;
    private int i = 0;//测试该类是否只创建一次，发现是只创建一次

    public List<TestUser> userList() {
        // 手动指定切换到数据源，切换到SQLServer数据库
        DynamicDataSourceHolder.setDataSource("dataSource1");
        List<TestUser> userList = testUserDao.queryAll();
        return userList;
    }

    @Override
    public List<Sqlserveruser> userListP() {
        // 手动指定切换到数据源，切换到SQLServer数据库
        DynamicDataSourceHolder.setDataSource("dataSource1");

        SqlserveruserExample userExample = new SqlserveruserExample();
        userExample.setOrderByClause("name desc");
        List<Sqlserveruser> userList = sqlserveruserDao.selectByExample(userExample);
        System.out.println("userList="+userList);

        return userList;
    }

    @Override//测试该类是否只创建一次，发现是只创建一次
    public int test() {
        i++;
        return i;
    }
}
