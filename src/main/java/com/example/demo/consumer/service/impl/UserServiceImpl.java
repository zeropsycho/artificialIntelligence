package com.example.demo.consumer.service.impl;

import com.example.demo.consumer.dao.UserDao;
import com.example.demo.consumer.entity.User;
import com.example.demo.consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import share.enums.StatusCode;
import share.exception.ReturnFormat;

/**
 * @author Administrator
 * @version V1.0
 * @Title: UserServiceImpl.java
 * @Package com.eureke.consumer.service.impl
 * @Description
 * @date 2018 07-02 19:53.
 */
@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public ReturnFormat updateUserById(User user) {
        int result;
        if (null == user) {
            return new ReturnFormat(StatusCode.UPDATE_FAILURE.getCode(), StatusCode.UPDATE_FAILURE.getMessage(), null, null);
        }
        result = userDao.updateUserById(user);
        if (result < 1) {
            return new ReturnFormat(StatusCode.UPDATE_FAILURE.getCode(), StatusCode.UPDATE_FAILURE.getMessage(), null, null);
        } else {
            return new ReturnFormat(StatusCode.UPDATE_SUCCESS.getCode(), StatusCode.UPDATE_SUCCESS.getMessage(), null, null);
        }
    }

    @Override
    public User selectUserFinal(User user) {
        return null;
    }

    /**
     * 添加人员
     * @param user 入参参数
     * @return int
     */
    @Override
    public int saveUser(User user) {
        int result = 0;
        result = userDao.saveUser(user);
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        return result;
    }

    /**
     *
     * @param user
     */
    @Override
    public void testTransactional(User user) {
        try {
            for (int i = 1; i < 5; i++) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void b(int i, User user) {
        try {
            if (i == 2) {
                userDao.saveUser(user);
                // 抛出ArithmeticException异常
                int a = 1 / 0;
            } else {
                userDao.saveUser(user);
            }
        } catch (Exception e) {
            // TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            throw new RuntimeException("插入出错！");
        }
    }
}
