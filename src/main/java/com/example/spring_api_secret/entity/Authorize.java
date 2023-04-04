package com.example.spring_api_secret.entity;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "authorize")
public class Authorize {

    @NotEmpty
    private String api;
    @NotEmpty
    private String apiVersion;
    @NotEmpty
    private String accessToken;
    @NotEmpty
    private String authToken;

    private Authorize(String accessToken, String authToken) {
        this.accessToken = accessToken;
        this.authToken = authToken;
    }

    public static @NotNull Authorize of(String accessToken, String authToken) {
        return new Authorize(accessToken, authToken);
    }
}
