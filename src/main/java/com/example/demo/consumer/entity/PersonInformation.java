package com.example.demo.consumer.entity;

import java.util.Date;

/**
 * @deprecated 个人信息
 * @author WenHui Li
 * @version V1.0
 * @date 2018 07-18 14:32
 */
public class PersonInformation {

    private Long id;

    private Long userId;

    private String name;

    private Byte sex;

    private Date birthday;

    private Date create;

    private Date update;

    /**
     * 默认构造方法
     */
    public PersonInformation() {
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public Date getCreate() {
        return create;
    }

    public void setCreate(Date create) {
        this.create = create;
    }

    public Date getUpdate() {
        return update;
    }

    public void setUpdate(Date update) {
        this.update = update;
    }

    @Override
    public String toString() {
        return "PersonInformation{" +
                "id=" + id +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", create=" + create +
                ", update=" + update +
                '}';
    }
}
