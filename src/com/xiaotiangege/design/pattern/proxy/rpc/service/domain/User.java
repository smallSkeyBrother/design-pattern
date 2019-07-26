package com.xiaotiangege.design.pattern.proxy.rpc.service.domain;

/**
 * @author wangfeilong
 * @version v1.0
 * @Description //TODO
 * @Date 2019/7/26 16:42
 **/
public class User {

    public User(String name, int age, String mobile) {
        this.name = name;
        this.age = age;
        this.mobile = mobile;
    }

    private String name;

    private int age;

    private String mobile;

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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
