package com.example.spring_api_secret.controller;

import com.example.spring_api_secret.entity.Authorize;
import com.example.spring_api_secret.dto.AuthorizeResponse;
import com.example.spring_api_secret.properties.SecurityConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/security")
public class SecurityController {

    @Autowired
    private final SecurityConfigProperties properties;

    public SecurityController(SecurityConfigProperties properties) {
        this.properties = properties;
    }

    @GetMapping("/info")
    public Map<String, String> info() {
        final Map<String, String> data = new HashMap<>();
        data.put("apiUrl", properties.apiUrl());
        data.put("apiVersion", properties.apiVersion());
        data.put("authToken", properties.authToken());
        data.put("databaseId", properties.databaseId());
        return data;
    }

    @GetMapping("/authorizer")
    public AuthorizeResponse token() {
        final AuthorizeResponse response = new AuthorizeResponse();
        final Authorize authorize = Authorize.of(properties.databaseId(), properties.authToken());
        authorize.setApi(properties.apiUrl());
        authorize.setApiVersion(properties.apiVersion());
        response.setAuthorize(authorize);
        return response;
    }
}
