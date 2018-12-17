package com.wnf.controller;

import com.github.pagehelper.PageInfo;
import com.wnf.entity.Sqlserveruser;
import com.wnf.entity.TestUser;
import com.wnf.entity.User;
import com.wnf.service.SqlServerTestUserService;
import com.wnf.service.UserService;
import com.wnf.utils.MyThrowException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class SQLServerTestController {

    @Autowired
    private SqlServerTestUserService sqlServerTestUserService;

    @ResponseBody
    @RequestMapping("/list")
    public List<TestUser> showIndex() {
        return sqlServerTestUserService.userList();
    }

    @ResponseBody
    @RequestMapping("/listP")
    public List<Sqlserveruser> listP() {
        return sqlServerTestUserService.userListP();
    }

    @ResponseBody
    @RequestMapping("/test")
    public String showIndex1() {

        return "i="+sqlServerTestUserService.test();
    }

    @ResponseBody//将返回的数据处理为json
    @RequestMapping(value = "/addTestTransactional")
    public String addTestTransactional(String phone, HttpServletRequest request, HttpServletResponse response) {
        User user = new User();
        user.setPhone(phone);
        user.setPassword("123456");
        user.setPermission(-1);
        user.setRegisterTime("20180101");
        user.setNickname("吴乃福");
        user.setHeadicon("icon001.png");
        user.setUserInfo("个人简介"+phone);
        String result = "";
        try {//将帖子内容、图片信息插入数据库
            result = sqlServerTestUserService.addTestTransactional(user);
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

    @ResponseBody
    @RequestMapping("/del/{id}")
    public String del(@PathVariable int id) {
        String result = "";
        try {//将帖子内容、图片信息插入数据库
            result = sqlServerTestUserService.delTestTransactional(id);
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

    @ResponseBody
    @RequestMapping("/update/{id}")
    public String update() {

        return "i="+sqlServerTestUserService.test();
    }

}
