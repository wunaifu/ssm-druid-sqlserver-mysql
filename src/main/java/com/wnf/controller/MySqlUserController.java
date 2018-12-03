package com.wnf.controller;

import com.github.pagehelper.PageInfo;
import com.wnf.entity.User;
import com.wnf.service.SqlServerTestUserService;
import com.wnf.service.UserService;
import com.wnf.utils.MyThrowException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by wunaifu on 2018/7/28.
 */
//tomcat配置好的项目地址是 + controller配好的RequestMapping + controller里面的接口方法配置好的RequestMapping
//    就是网络请求时的地址，即访问controller中某方法的网络地址URL
//    例如：http://localhost:8080/user/allUser --》就访问了findAllUserDESC（）方法
@Controller
//@RequestMapping("/user")//Controller类继承BaseExceptionHandleAction这个类即可在产生异常时返回数据获取失败的异常类信息
public class MySqlUserController {

    //这里写的每个方法都要注释好是干什么的，有复杂的逻辑处理关系的也要注释好，便于别人读懂你的代码
    //PS:controller一般只处理获取数据，将数据传到service业务层，不做复杂的数据处理，复杂的数据处理交给service业务层

    //注入Service实现类依赖，可注入多个Service依赖
    @Autowired
    private UserService userService;
    @Autowired
    private SqlServerTestUserService sqlServerTestUserService;

    @ResponseBody//将返回的数据处理为json
    @RequestMapping(value = "/user/add")
    public String userAdd(String phone,HttpServletRequest request, HttpServletResponse response) {
        User user = new User();
        user.setPhone(phone);
        user.setPassword("123456");
        user.setPermission(-1);
        user.setRegisterTime("20180101");
        user.setNickname("吴乃福");
        user.setHeadicon("icon001.png");
        user.setUserInfo("个人简介"+phone);
        user.setHeadicon("icon001.png");
        user.setUserInfo("个人简介"+phone);
        String result = "";
        try {//将帖子内容、图片信息插入数据库
            result = userService.addUser(user);
            //捕捉事务控制抛出的异常，防止程序异常崩溃
        } catch (MyThrowException e) {
            System.out.println("异常捕捉：MyThrowException：" + e.getMessage());
            e.printStackTrace();
            result = "异常捕捉：MyThrowException：" + e.getClass();
        } catch (Exception e) {
            System.out.println("异常捕捉：Exception：" + e.getMessage());
            result = "异常捕捉：Exception：" + e.getClass();
            e.printStackTrace();
        }
        return result;
    }

    @ResponseBody//将返回的数据处理为json
    @RequestMapping(value = "/user/list")
    public PageInfo userList(int page, int rows, HttpServletRequest request, HttpServletResponse response) {

        return userService.userListPager(page,rows);
    }

    @ResponseBody//将返回的数据处理为json
    @RequestMapping(value = "/user/list2")
    public List<User> userList2(int pageNo,int pageSize,int startRow,HttpServletRequest request, HttpServletResponse response) {

        return userService.userList2(pageNo,pageSize,startRow);
    }


    @ResponseBody//将返回的数据处理为json
    @RequestMapping(value = "/user/test")
    public String userAddTest(String phone,HttpServletRequest request, HttpServletResponse response) {
        User user = new User();
        user.setPhone(phone);
        user.setPassword("123456");
        user.setPermission(-1);
        user.setRegisterTime("20180101");
        user.setNickname("吴乃福");
        user.setHeadicon("icon001.png");
        user.setUserInfo("个人简介"+phone);
        user.setHeadicon("icon001.png");
        user.setUserInfo("个人简介"+phone);
//        user.getAddress();
//        Integer.parseInt("dsfa");
        return userService.addUser(user);
    }

    @ResponseBody
    @RequestMapping("/test2")
    public String showIndex1() {

        return "i="+sqlServerTestUserService.test();
    }
}
