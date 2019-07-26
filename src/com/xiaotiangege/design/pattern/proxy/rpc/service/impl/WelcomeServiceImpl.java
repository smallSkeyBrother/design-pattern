package com.xiaotiangege.design.pattern.proxy.rpc.service.impl;

import com.xiaotiangege.design.pattern.proxy.rpc.service.WelcomeService;
import com.xiaotiangege.design.pattern.proxy.rpc.service.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangfeilong
 * @version v1.0
 * @Description 实现接口
 * @Date 2019/7/26 14:21
 **/
public class WelcomeServiceImpl implements WelcomeService {
    @Override
    public List<User> listUsers() {
        List<User> list = new ArrayList<>();
        list.add(new User("张三", 20, "110"));
        list.add(new User("lisi", 22, "110110"));
        return list;
    }

    @Override
    public String sayHello(String name) {
        return "welcome to rpc test " + name;
    }
}
