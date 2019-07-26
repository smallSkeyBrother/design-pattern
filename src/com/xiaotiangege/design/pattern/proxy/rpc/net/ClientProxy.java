package com.xiaotiangege.design.pattern.proxy.rpc.net;

import com.xiaotiangege.design.pattern.proxy.rpc.service.WelcomeService;
import com.xiaotiangege.design.pattern.proxy.rpc.service.impl.WelcomeServiceImpl;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author wangfeilong
 * @version v1.0
 * @Description 代理接口
 * @Date 2019/7/26 14:17
 **/
public class ClientProxy implements InvocationHandler {
    Socket socket = null;

    private Object proxy;

    public ClientProxy(String ip, int port) throws UnknownHostException, IOException {
        Socket socket = new Socket(ip, port);
        this.socket = socket;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeUTF(method.getName());
        oos.writeUTF(WelcomeServiceImpl.class.getName());
        oos.writeObject(method.getParameterTypes());
        oos.writeObject(args);
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        return ois.readObject();
    }

    public WelcomeService getService() {
        return (WelcomeService) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class<?>[]{WelcomeService.class}, this);
    }
}
