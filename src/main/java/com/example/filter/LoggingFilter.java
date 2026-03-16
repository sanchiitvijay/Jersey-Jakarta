package com.example.filter;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.ext.Provider;

@Provider
public class LoggingFilter implements ContainerRequestFilter{
    
    private static final Logger log =
            LoggerFactory.getLogger(LoggingFilter.class);

    public void filter(ContainerRequestContext ctx) throws IOException {
        log.info("Incoming request {} {}",
                ctx.getMethod(),
                ctx.getUriInfo().getPath());
    }
}
