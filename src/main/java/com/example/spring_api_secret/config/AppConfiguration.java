package com.example.spring_api_secret.config;

import org.jetbrains.annotations.NotNull;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {
    public void customize(@NotNull ConfigurableServletWebServerFactory factory){
        //factory.setPort(8080);
    }
}
