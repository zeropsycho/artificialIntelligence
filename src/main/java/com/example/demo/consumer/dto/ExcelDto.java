package com.example.demo.consumer.dto;

import java.util.Date;

/**
 * @author ZERO
 * @version V1.0
 * @description 导入，导出实体类
 * @package com.example.demo.consumer.dto
 * @date 2018 08-06 22:08
 */
public class ExcelDto {

    private String name;

    private int age;

    private Date birthday;

    private double height;

    private float weight;

    private boolean sex;

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "ExcelDto{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", height=" + height +
                ", weight=" + weight +
                ", sex=" + sex +
                '}';
    }
}
