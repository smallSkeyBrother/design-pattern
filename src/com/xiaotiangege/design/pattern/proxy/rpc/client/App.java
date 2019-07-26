package com.xiaotiangege.design.pattern.proxy.rpc.client;

import com.xiaotiangege.design.pattern.proxy.rpc.net.ClientProxy;
import com.xiaotiangege.design.pattern.proxy.rpc.service.WelcomeService;

import java.io.IOException;
import java.net.UnknownHostException;

/**
 * @author wangfeilong
 * @version v1.0
 * @Description 测试客户端
 * @Date 2019/7/26 14:26
 **/
public class App {

    public static void main(String[] args) throws UnknownHostException, IOException {
        String ip = "127.0.0.1";
        int port = 8989;

        ClientProxy clientProxy = new ClientProxy(ip, port);
        WelcomeService wService = clientProxy.getService();

        System.out.println(wService.sayHello("coder"));

        //System.out.println(wService.listUsers());
    }
}
