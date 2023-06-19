package com.javasm.socket.webserver.server;

import com.javasm.socket.webserver.http.Request;
import com.javasm.socket.webserver.http.Response;
import com.javasm.socket.webserver.servlet.BaseServlet;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.SocketHandler;

/**
 * @author:
 * @className: WebThread
 * @description: 开启线程
 * @date: 2023/5/30 16:59
 * @since: 11
 */
public class WebThread extends Thread {
    private Socket socket;

    public WebThread(Socket socket) {
        this.socket = socket;
    }

    // 定义线程执行的任务
    @Override
    public void run() {
        try {
            // 数据交互
            Request request = new Request(socket.getInputStream());
            Response response = new Response(socket.getOutputStream());
            // 获取请求路径
            String reqUrl = request.getReqUrl();
            // 找到对应的服务类
            BaseServlet baseServlet = Web.mappers.get(reqUrl);
            // 判断
            if (baseServlet != null) {
                baseServlet.myService(request, response);
            } else {
                // 返回响应数据
                OutputStream writer = response.getWriter();
                writer.write(Response.respHeaders.getBytes());
                writer.write("404 not found!!!".getBytes());
                writer.flush();
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
