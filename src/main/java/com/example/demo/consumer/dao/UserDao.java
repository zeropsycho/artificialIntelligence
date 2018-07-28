package com.example.demo.consumer.dao;

import com.example.demo.consumer.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Administrator
 * @version V1.0
 * @Title: UserDao.java
 * @Package com.eureke.consumer.dao
 * @Description
 * @date 2018 07-03 9:44.
 */
@Mapper
public interface UserDao {

    /**
     * 查看list集合
     * @param user
     * @return
     */
    User listUser(User user);

    /**
     * 保存到userDao中
     * @param user user对象
     * @return int
     */
    int saveUser(User user);

    void testTransaction(User user);

    /**
     * 根据人员id进行修改人员信息
     * @param user
     * @return
     */
    int updateUserById(User user);
}