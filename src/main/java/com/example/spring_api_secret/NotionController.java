package com.example.spring_api_secret;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class NotionController {

    @Autowired
    private final NotionConfigProperties notionConfig;

    public NotionController(NotionConfigProperties notionConfig) {
        this.notionConfig = notionConfig;
    }

    @GetMapping("/info")
    public Map<String, String> info() {
        final Map<String, String> data = new HashMap<>();
        data.put("apiUrl", notionConfig.apiUrl());
        data.put("apiVersion", notionConfig.apiVersion());
        data.put("authToken", notionConfig.authToken());
        data.put("databaseId", notionConfig.databaseId());
        return data;
    }
}
