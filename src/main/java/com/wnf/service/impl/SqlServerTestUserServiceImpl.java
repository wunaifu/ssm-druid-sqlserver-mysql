package com.wnf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wnf.dao.SqlserveruserDao;
import com.wnf.dao.TestUserDao;
import com.wnf.dao.UserDao;
import com.wnf.datasource.DynamicDataSourceHolder;
import com.wnf.entity.*;
import com.wnf.service.SqlServerTestUserService;
import com.wnf.utils.MyThrowException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

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

    @Autowired
    private UserDao userDao;

    /**
     * 更新双数据库，事务不能用
     * @param user
     * @return
     */
//    @Transactional
    public String addTestTransactional(User user) {

        // 手动指定切换到数据源，切换到SQLServer数据库
        DynamicDataSourceHolder.setDataSource("dataSourceMySql");
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andPhoneEqualTo(user.getPhone());
        List<User> userList = userDao.selectByExample(userExample);
        if (userList != null && userList.size() > 0) {
            return "user_exist";
        } else {
            try {
                if (userDao.insertSelective(user) == 1) {

                    Sqlserveruser sqlserveruser = new Sqlserveruser();
                    sqlserveruser.setId(new Random().nextInt(99));
                    sqlserveruser.setName(String.valueOf(new Random().nextInt(99)));
                    sqlserveruser.setAddress(String.valueOf(new Random().nextInt(99)));
                    // 手动指定切换到数据源，切换到SQLServer数据库
                    DynamicDataSourceHolder.setDataSource("dataSourceSqlServer");
                    if (sqlserveruserDao.insert(sqlserveruser)==1) {
                        return "register_success";
                    } else {
                        throw new MyThrowException("register_failure");
                    }
                } else {
                    throw new MyThrowException("register_failure");
                }
            } catch (MyThrowException e) {
                throw e;
            }
        }
    }

    @Transactional
    public String delTestTransactional(int id) {
        // 手动指定切换到数据源，切换到SQLServer数据库
        DynamicDataSourceHolder.setDataSource("dataSourceSqlServer");
        try {
            if (sqlserveruserDao.deleteByPrimaryKey(id) == 1) {
                Sqlserveruser sqlserveruser = new Sqlserveruser();
                sqlserveruser.setId(2);
                sqlserveruser.setName(String.valueOf(new Random().nextInt(99)));
                sqlserveruser.setAddress(String.valueOf(new Random().nextInt(99)));
                if (sqlserveruserDao.updateByPrimaryKeySelective(sqlserveruser)==1) {
//                    return "success";
                    throw new MyThrowException("failure");
                } else {
                    throw new MyThrowException("failure");
                }
            } else {
                throw new MyThrowException("failure");
            }
        } catch (MyThrowException e) {
            throw e;
        }

    }

    @Transactional
    public String updateTestTransactional(int id) {
        return "user_exist";
    }

    public List<TestUser> userList() {
        // 手动指定切换到数据源，切换到SQLServer数据库
        DynamicDataSourceHolder.setDataSource("dataSourceSqlServer");
        List<TestUser> userList = testUserDao.queryAll();
        return userList;
    }

    @Override
    public List<Sqlserveruser> userListP() {
        // 手动指定切换到数据源，切换到SQLServer数据库
        DynamicDataSourceHolder.setDataSource("dataSourceSqlServer");

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
