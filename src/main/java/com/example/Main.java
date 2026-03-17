package com.example;

import java.net.URI;

import org.glassfish.grizzly.http.server.CLStaticHttpHandler;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import com.example.config.MyApplication;

public class Main {
    public static void main(String[] args) throws Exception {
        ResourceConfig config = new MyApplication();

        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(
            URI.create("http://localhost:8080/"),
            config,
            false
        );

        server.getServerConfiguration().addHttpHandler(
            new CLStaticHttpHandler(
                Main.class.getClassLoader(),
                "swagger-ui/",
                "META-INF/resources/webjars/swagger-ui/5.17.14/"
            ),
            "/swagger-ui/"
        );

        server.start();

        System.out.println("Server started at http://localhost:8080/");
        Thread.currentThread().join();
    }
}
