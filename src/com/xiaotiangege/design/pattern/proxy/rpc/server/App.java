package com.xiaotiangege.design.pattern.proxy.rpc.server;

import com.xiaotiangege.design.pattern.proxy.rpc.net.ServerProxy;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author wangfeilong
 * @version v1.0
 * @Description //TODO
 * @Date 2019/7/26 15:26
 **/
public class App {

    public static void main(String[] args) throws IOException {

        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        ServerSocket ss = new ServerSocket(8989);
        System.out.println("server start success");

        while (true){
            Socket client = ss.accept();
            System.out.println("client request coming ...");
            ServerProxy serverProxy = new ServerProxy(client);
            executorService.execute(serverProxy);
        }
    }
}
