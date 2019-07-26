package com.xiaotiangege.design.pattern.proxy.rpc.net;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * @author wangfeilong
 * @version v1.0
 * @Description //TODO
 * @Date 2019/7/26 14:20
 **/
public class ServerProxy implements Runnable {
    private Socket socket;

    public ServerProxy(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        try {
            ois = new ObjectInputStream(socket.getInputStream());
            String methodName = ois.readUTF();
            String className = ois.readUTF();
            Class<?> serviceInterface = Class.forName(className);
            Class<?>[] paramTypes = (Class<?>[]) ois.readObject();
            Object[] param = (Object[]) ois.readObject();

            System.out.println("request class: " + methodName + "\n\rrequest method: " + className + "\n\rparam: " + param.toString());

            Method method = serviceInterface.getMethod(methodName, paramTypes);
            Object ret = method.invoke(serviceInterface.newInstance(), param);

            System.out.println("response result :" + ret.toString());

            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(ret);
            oos.flush();

        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (Exception e) {
                }
            }

            if (oos != null) {
                try {
                    oos.close();
                } catch (Exception e) {
                }
            }

            if (socket != null) {
                try {
                    socket.close();
                } catch (Exception e) {
                }
            }
        }
    }
}
