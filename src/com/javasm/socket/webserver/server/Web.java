package com.javasm.socket.webserver.server;

import com.javasm.socket.webserver.http.Request;
import com.javasm.socket.webserver.http.Response;
import com.javasm.socket.webserver.servlet.BaseServlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author:
 * @className: Web
 * @description: 开启服务端，监听客户端的连接
 * @date: 2023/5/30 15:23
 * @since: 11
 */
public class Web {
    // 创建Map集合
    public static Map<String, BaseServlet> mappers = new HashMap<>();

    // 读取配置文件的数据
    public static void readFile() {
        // 读取配置文件的数据
        Properties properties = new Properties();
        try {
            // 可以读取src下的文件
            properties.load(Web.class.getClassLoader().getResourceAsStream("mapper.properties"));
            // 需要参照路径(相对路径)
            // properties.load(Web.class.getResourceAsStream("../../../../../mapper.properties"));
            // properties.load(new FileInputStream("E:\\workspace\\section6-Socket\\src\\mapper.properties"));
            // System.out.println(properties);
            // 获取所有的key
            Set<Object> keySet = properties.keySet();
            // 遍历所有的key，找到url的key
            for (Object key : keySet) {
                if (key.toString().contains("url")) {
                    // 获取url值   /regist  /login
                    String urlValue = properties.getProperty(key.toString());
                    // 获取class的key值
                    String classKey = key.toString().replace("url", "class");
                    // 获取class的value值
                    String classValue = properties.getProperty(classKey);
                    // 使用反射
                    BaseServlet baseServlet = (BaseServlet) Class.forName(classValue).getConstructor().newInstance();
                    // 将urlValue和BaseServlet存入Map中
                    mappers.put(urlValue, baseServlet);
                }
            }
            System.out.println(mappers);
        } catch (IOException | ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    // 开启服务端，监听客户端的连接
    public static void startWeb() {
        try {
            // 创建ServerSocket对象，指定端口号
            ServerSocket serverSocket = new ServerSocket(8083);
            System.out.println("服务端已开启，监听8083端口");
            while (true) {
                // 监听客户端的连接
                Socket socket = serverSocket.accept();
                // 开启线程
                WebThread webThread = new WebThread(socket);
                webThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        readFile();
        startWeb();
    }

}
