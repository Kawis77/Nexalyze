package com.nexalyze.nexalyze.configuration.security.login.model;

import io.micrometer.common.util.StringUtils;

public class TokenResponse {

    private String token;
    private String message;

    public TokenResponse() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
