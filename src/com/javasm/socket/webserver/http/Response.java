package com.javasm.socket.webserver.http;

import java.io.OutputStream;

/**
 * @author: zk
 * @className: Server
 * @description: ToDo
 * @date: 2023/06/17/11:24
 * @since: 11
 */
public class Response {
    // 输出流
    private OutputStream writer;

    // 响应报文格式
    public static final String respHeaders = "HTTP/1.1 200 OK\r\n" +
            "Content-Type: text/html; charset=utf-8\r\n" +
            "\r\n";

    public Response(OutputStream outputStream) {
        writer = outputStream;
    }

    public OutputStream getWriter() {
        return writer;
    }

}
