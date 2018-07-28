package com.example.demo.consumer.service;

import com.example.demo.consumer.entity.User;
import share.exception.ReturnFormat;


/**
 * @author Administrator
 * @version V1.0
 * @Title: UserService.java
 * @Package com.eureke.consumer.service.impl
 * @Description
 * @date 2018 07-02 19:52.
 *All Rights Reserved.
 */
public interface UserService {

    User selectUserFinal(User user);

    int saveUser(User user);

    void b(int i, User user);

    void testTransactional(User user);

    /**
     * 根据id更新人员信息
     * @param user
     * @return
     */
    ReturnFormat updateUserById(User user);
}

