package com.example;

import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Main {
    public static void main(String[] args) throws Exception {
        ResourceConfig config = new ResourceConfig().packages("com.example");

        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(
            URI.create("http://localhost:8080/"),
            config
        );
        System.out.println("Server started at http://localhost:8080/");
        Thread.currentThread().join();
    }
}
