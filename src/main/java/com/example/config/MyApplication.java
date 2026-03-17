package com.example.config;

import com.example.service.UserService;

import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import jakarta.inject.Singleton;
import org.glassfish.jersey.internal.inject.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

public class MyApplication extends ResourceConfig {
    public MyApplication(){
        packages("com.example");
        register(new AbstractBinder() {
            @Override
            protected void configure() {
                bindAsContract(UserService.class).in(Singleton.class);
            }
        });
        register(OpenApiResource.class);
    }
}
