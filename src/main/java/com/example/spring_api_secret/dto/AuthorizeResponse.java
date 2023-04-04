package com.example.spring_api_secret.dto;

import com.example.spring_api_secret.entity.Authorize;
import lombok.Data;

@Data
public class AuthorizeResponse {
    private String error;
    private Authorize authorize;
}

