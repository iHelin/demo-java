package io.github.ihelin.demo.test.my.rpc.service1;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * @author iHelin
 * @since 2018/4/12 09:46
 */
public class Main {

    public static void main(String[] args) {
        IProductService productService = (IProductService) rpc(IProductService.class);
        Product product = productService.queryById(200);
        System.out.println(product);
    }

    public static Object rpc(final Class clazz) {
        return Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz},
                (proxy, method, args) -> {
                    Socket socket = new Socket("127.0.0.1", 8888);
                    String apiClassName = clazz.getName();
                    String methodName = method.getName();
                    Class[] parameterTypes = method.getParameterTypes();
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                    objectOutputStream.writeUTF(apiClassName);
                    objectOutputStream.writeUTF(methodName);
                    objectOutputStream.writeObject(parameterTypes);
                    objectOutputStream.writeObject(args);
                    objectOutputStream.flush();
                    ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                    Object o = objectInputStream.readObject();
                    objectOutputStream.close();
                    objectInputStream.close();
                    socket.close();
                    return o;
                });
    }
}
