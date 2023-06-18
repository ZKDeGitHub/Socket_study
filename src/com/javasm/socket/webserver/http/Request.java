package com.javasm.socket.webserver.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author: zk
 * @className: Server
 * @description: ToDo
 * @date: 11:23
 * @since: 11
 */
public class Request {
    // 请求方法
    private String reqMethod;
    // 请求路径
    private String reqUrl;

    public Request(InputStream inputStream) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            // 读取一行数据
            String readLine = reader.readLine();
            String[] split = readLine.split(" ");
            reqMethod = split[0];
            reqUrl = split[1];
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getReqMethod() {
        return reqMethod;
    }

    public String getReqUrl() {
        return reqUrl;
    }
}
