package com.example.demo.consumer.service.impl;

import com.example.demo.consumer.entity.User;
import com.example.demo.consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ZERO
 * @version V1.0
 * @description 测试事务是否有效
 * @package com.example.demo.consumer.service.impl
 * @date 2018 07-20 12:44
 */
@Service
public class TestUser {
    @Autowired
    private UserService userService;

    /**
     * 记录事务处理时，每次循环，将当前异常的循环中回滚事务，未抛出异常的事务不回滚
     * @param user
     */
    public void a(User user) {
        for (int i = 1; i < 5; i++) {
            try {
                userService.b(i, user);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
