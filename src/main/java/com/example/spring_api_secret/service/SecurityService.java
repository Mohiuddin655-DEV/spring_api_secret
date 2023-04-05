package com.example.spring_api_secret.service;

import com.example.spring_api_secret.dto.Response;
import com.example.spring_api_secret.entity.Api;
import com.example.spring_api_secret.properties.SecurityConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SecurityService {

    @Autowired
    private SecurityConfigProperties properties;

    public SecurityService(SecurityConfigProperties properties) {
        this.properties = properties;
    }

    public Map<String, String> info() {
        final Map<String, String> data = new HashMap<>();
        data.put("apiUrl", properties.apiUrl());
        data.put("apiVersion", properties.apiVersion());
        data.put("authToken", properties.authToken());
        data.put("databaseId", properties.databaseId());
        return data;
    }

    public Response<Api> auth() {
        return Response.withData(Api.of(
                properties.apiUrl(),
                properties.apiVersion(),
                properties.databaseId(),
                properties.authToken()
        ));
    }

}
