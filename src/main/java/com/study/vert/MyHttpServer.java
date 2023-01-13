package com.study.vert;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;

public class MyHttpServer {


    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        HttpServer server = vertx.createHttpServer();
        server.requestHandler(request -> {
            HttpServerResponse response = request.response();

            response.putHeader("Content-type", "text/html;charset=utf-8");

            response.end("Hello World");
        });
        // 部署服务，会执行MyHttpServer的start方法
        server.listen(8888);
    }


}

