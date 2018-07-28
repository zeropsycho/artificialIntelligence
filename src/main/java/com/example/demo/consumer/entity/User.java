package com.example.demo.consumer.entity;

/**
 * @author Administrator
 * @version V1.0
 * @Title: User.java
 * @Package com.eureke.consumer.entity
 * @Description 用户实体类
 * @date 2018 07-02 19:49.
 */
public class User {

    private Long id;
    private String userName;
    private String passWord;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
