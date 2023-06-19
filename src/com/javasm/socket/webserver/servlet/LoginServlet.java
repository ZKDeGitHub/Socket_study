package com.javasm.socket.webserver.servlet;

import com.javasm.socket.webserver.http.Request;
import com.javasm.socket.webserver.http.Response;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author: zk
 * @className: Server
 * @description: ToDo
 * @date: 2023/06/17/11:30
 * @since: 11
 */
public class LoginServlet extends BaseServlet {
    @Override
    public void myDoGet(Request request, Response response) throws IOException {
        // 获取输出流
        OutputStream writer = response.getWriter();
        // 写出响应数据
        writer.write(Response.respHeaders.getBytes());
        writer.write("login ok!!!".getBytes());
        // 资源关闭
        writer.flush();
        writer.close();
    }

    @Override
    public void myDoPost(Request request, Response response) throws IOException {

    }
}
