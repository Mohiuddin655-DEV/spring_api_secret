package com.example.spring_api_secret.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("secret")
public record SecurityConfigProperties(String apiUrl, String apiVersion, String authToken, String databaseId) {
}
