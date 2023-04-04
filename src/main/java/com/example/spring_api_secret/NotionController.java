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
    public String printAllProps() {
        return "Info";
//        if (notionConfig == null){
//            return  Map.of(
//                    "Message", "notion config is null"
//            );
//        }
//        return Map.of(
//                "apiUrl", notionConfig.apiUrl(),
//                "apiVersion", notionConfig.apiVersion(),
//                "authToken", notionConfig.authToken(),
//                "databaseId", notionConfig.databaseId()
//        );
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, I'm here!";
    }
}
