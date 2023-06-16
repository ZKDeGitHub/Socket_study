package com.javasm.socket.basic;

import java.io.IOException;
import java.net.ServerSocket;

public class Sever {
    public static void main(String[] args) {
        try {

            // 创建ServerSocket对象，指定端口号
            ServerSocket serverSocket = new ServerSocket(8081);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
