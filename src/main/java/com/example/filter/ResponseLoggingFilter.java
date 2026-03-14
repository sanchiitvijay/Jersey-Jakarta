package com.example.filter;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;

import java.io.IOException;

@Provider
public class ResponseLoggingFilter implements ContainerResponseFilter {

    @Override
    public void filter(
            ContainerRequestContext request,
            ContainerResponseContext response
    ) throws IOException {

        System.out.println(
            "Response status: " + response.getStatus()
        );
    }
}