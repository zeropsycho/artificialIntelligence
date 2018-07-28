package com.example.demo.consumer.controller;

import com.example.demo.consumer.entity.User;
import com.example.demo.consumer.service.UserService;
import com.example.demo.consumer.service.impl.TestUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import share.constant.RequestHeader;

import javax.validation.Valid;

/**
 * @author Administrator
 * @version V1.0
 * @Title: UserController.java
 * @Package com.eureke.consumer.controller
 * @Description 人员信息操作
 * @date 2018 07-03 11:32.
 */
@RestController
@RequestMapping(RequestHeader.REQUEST_HEADER_USER)
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TestUser testUser;

    /**
     * 人员录入
     * @param user 用户信息
     * @return
     */
    @PostMapping("/save")
    public User saveUser(@RequestBody @Valid User user) {
        testUser.a(user);
        return user;
    }
}
