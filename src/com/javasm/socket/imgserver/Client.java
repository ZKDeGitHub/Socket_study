package com.javasm.socket.imgserver;

import java.io.*;
import java.net.Socket;

/**
 * @author:
 * @className: Client
 * @description: 客户端
 * @date:
 * @since:
 */
public class Client {
    public static void main(String[] args) {
        // 客户端要读取文件的位置
        String clientPath = "D:\\img\\02.jpg";
        try {

            // 创建Socket对象，指定IP地址和端口号
            Socket socket = new Socket("127.0.0.1", 8082);

            // 数据交互
            // IO流：字节缓冲输入流、字节缓冲输出流
            try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(new File(clientPath)));
                 BufferedOutputStream outputStream = new BufferedOutputStream(socket.getOutputStream());) {
                int len = -1;
                while ((len = inputStream.read()) != -1) {
                    outputStream.write(len);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
