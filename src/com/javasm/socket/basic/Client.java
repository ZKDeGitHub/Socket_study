package com.javasm.socket.basic;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {


        try {
            // 创建Socket对象，指定IP地址和端口号
            Socket socket = new Socket("127.0.0.1",8081);

            // 数据交互
            // 客户端：读取内容，输入流
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            System.out.println("客户端接收的内容" + dataInputStream.readUTF());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
