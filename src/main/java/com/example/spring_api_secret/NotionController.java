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
    public Map<String, String> printAllProps() {
//        final Map<String, String> data = Map.of(
//                "apiUrl", notionConfig.apiUrl(),
//                "apiVersion", notionConfig.apiVersion(),
//                "authToken", notionConfig.authToken(),
//                "databaseId", notionConfig.databaseId()
//        );
        Map<String, String> data = new HashMap<>();
        data.put("apiUrl", "");
        data.put("apiVersion", "");
        data.put("authToken", "");
        data.put("databaseId", "");
        return data;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, I'm here!";
    }
}
