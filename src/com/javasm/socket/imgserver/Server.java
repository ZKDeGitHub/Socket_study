package com.javasm.socket.imgserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

/**
 * @author:
 * @className: Server
 * @description: 服务端
 * @date: 2023/5/27 17:49
 * @since: 11
 */
public class Server {
    public static void main(String[] args) {
        try {
            // 服务端保存文件的位置
            String serverPath = "D:\\Java\\code\\Socket_study\\img";

            // 创建ServerSocket对象，指定端口号
            ServerSocket serverSocket = new ServerSocket(8082);
            System.out.println("服务端已开启，监听8082端口");
            // 死循环-不断监听客户端的连接
            while (true) {
                // 监听客户端的连接
                Socket socket = serverSocket.accept();
                String hostAddress = socket.getInetAddress().getHostAddress();
                System.out.println("连接到的客户端是：" + hostAddress);
                // 数据交互
                // IO流：字节缓冲输入流、字节缓冲输出流
                try (BufferedInputStream inputStream = new BufferedInputStream(socket.getInputStream());
                     BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(new File(serverPath, UUID.randomUUID() + ".jpg")));) {
                    int len = -1;
                    while ((len = inputStream.read()) != -1) {
                        outputStream.write(len);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
