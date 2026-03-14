package com.example.filter;

import java.io.IOException;

import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.ext.Provider;

@Provider
public class LoggingFilter implements ContainerRequestFilter{
    
    @Override
    public void filter(ContainerRequestContext ctx) throws IOException {
        String method = ctx.getMethod();
        String path = ctx.getUriInfo().getPath();

        System.out.println("Incoming request: " + method + " " + path);
    }
}
