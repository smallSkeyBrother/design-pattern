package com.xiaotiangege.design.pattern.proxy.rpc.service;

import com.xiaotiangege.design.pattern.proxy.rpc.service.domain.User;

import java.util.List;

/**
 * @author wangfeilong
 * @version v1.0
 * @Description //TODO
 * @Date 2019/7/26 14:21
 **/
public interface WelcomeService {

    String sayHello(String name);

    List<User> listUsers();
}
