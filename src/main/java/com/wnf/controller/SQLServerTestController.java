package com.wnf.controller;

import com.wnf.entity.TestUser;
import com.wnf.service.SqlServerTestUserService;
import com.wnf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SQLServerTestController {

    @Autowired
    private SqlServerTestUserService userService;

    @ResponseBody
    @RequestMapping("/list")
    public List<TestUser> showIndex() {
        return userService.userList();
    }

    @ResponseBody
    @RequestMapping("/test")
    public String showIndex1() {
        return "jifdasj";
    }

}
