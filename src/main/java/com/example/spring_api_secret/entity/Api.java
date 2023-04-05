package com.example.spring_api_secret.entity;

import jakarta.validation.constraints.NotEmpty;

public class Api {
    @NotEmpty
    private String baseUrl;
    @NotEmpty
    private String version;
    @NotEmpty
    private String accessToken;
    @NotEmpty
    private String authToken;

    public String getBaseUrl() {
        return baseUrl;
    }

    private static Api proxy;

    public Api setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    public String getVersion() {
        return version;
    }

    public Api setVersion(String version) {
        this.version = version;
        return this;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public Api setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public String getAuthToken() {
        return authToken;
    }

    public Api setAuthToken(String authToken) {
        this.authToken = authToken;
        return this;
    }

    public static Api of(String url, String version) {
        proxy = new Api().setBaseUrl(url).setVersion(version);
        return proxy;
    }

    public static Api of(String url, String version, String accessToken, String authToken) {
        proxy = new Api().setBaseUrl(url).setVersion(version).setAccessToken(accessToken).setAuthToken(authToken);
        return proxy;
    }

    public Api with(String accessToken, String authToken) {
        return (proxy != null ? proxy : new Api()).setAccessToken(accessToken).setAuthToken(authToken);
    }
}
