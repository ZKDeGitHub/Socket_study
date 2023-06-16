package com.javasm.socket.basic;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Sever {
    public static void main(String[] args) {
        try {

            // 创建ServerSocket对象，指定端口号
            ServerSocket serverSocket = new ServerSocket(8081);
            System.out.println("服务器端已开启，监听8081端口");

            // 设置死循环-不断监听客户端的连接
            while(true){

                // 监听客户端的连接，是一个阻塞方法
                Socket socket = serverSocket.accept();

                // 获取来连接服务端的客户端
                String hostAddress = socket.getInetAddress().getHostAddress();
                System.out.println("未连接的客户端" + hostAddress);

                // 数据交互
                // 服务端：写出内容，输出流
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataOutputStream.writeUTF("你好，客户端" + hostAddress);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
