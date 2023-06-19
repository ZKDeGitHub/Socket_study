package com.javasm.socket.webserver.servlet;

import com.javasm.socket.webserver.http.Request;
import com.javasm.socket.webserver.http.Response;

import java.io.IOException;

/**
 * @author: zk
 * @className: Server
 * @description: ToDo
 * @date: 2023/06/17/11:30
 * @since: 11
 */
public abstract class BaseServlet {
    // 请求对象(接收请求数据)、响应对象(写出响应数据)
    public void myService(Request request, Response response) throws IOException {
        // 获取请求方法
        String reqMethod = request.getReqMethod();
        // 方法细分  get post
        if ("GET".equals(reqMethod)) {
            myDoGet(request, response);
        } else if ("POST".equals(reqMethod)) {
            myDoPost(request, response);
        }
    }

    public abstract void myDoGet(Request request, Response response) throws IOException;

    public abstract void myDoPost(Request request, Response response) throws IOException;

}
