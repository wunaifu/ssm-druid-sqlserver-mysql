package com.wnf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.wnf.dao.UserDao;
import com.wnf.entity.User;
import com.wnf.entity.UserExample;
import com.wnf.service.UserService;
import com.wnf.utils.MyThrowException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wunaifu on 2018/7/28.
 */
@Service
public class UserServiceImpl implements UserService {

    //注入Dao实现类依赖
    //    @Resource
    @Autowired
    private UserDao userDao;

    /**
     * 事务例子，多条数据修改操作时使用事务，保证数据一致修改通过
     * @param user
     * @return
     */
    @Transactional
    public String addUser(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andPhoneEqualTo(user.getPhone());
        List<User> userList = userDao.selectByExample(userExample);
        if (userList != null && userList.size() > 0) {
            return "user_exist";
        } else {
            try {
                if (userDao.insertSelective(user) == 1) {
//                    if (userDao.insertSelective(user) == 1) {
                        return "register_success";
//                    } else {
//                        throw new MyThrowException("register_failure");
//                    }
                } else {
                    throw new MyThrowException("register_failure");
                }
            } catch (MyThrowException e) {
                throw e;
            }
        }
    }

    public List<User> userList2() {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();

        List<User> userList = userDao.selectByExample(userExample);
        return userList;
    }

    public PageInfo userListPager(int page, int rows) {
        //设置分页信息,获取第page页，rows条内容，默认查询总数count
        PageHelper.startPage(page,rows);
        //执行查询,紧跟着的第一个select方法会被分页
        UserExample userExample = new UserExample();
        List<User> userList = userDao.selectByExample(userExample);
        System.out.println("userList="+userList);
        //取查询结果,用PageInfo对结果进行包装
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return pageInfo;
    }

    public List<User> userList2(int pageNo,int pageSize,int startRow) {
        UserExample userExample = new UserExample();
        userExample.setOrderByClause("user_id desc,phone desc");
//        userExample.setStartRow(startRow);
//        userExample.setPageSize(pageSize);
//        userExample.setPageNo(pageNo);
//        List<User> userList = userDao.selectByExampleWithBLOBs(userExample);
        List<User> userList = userDao.selectByExample(userExample);

        return userList;
    }

}
