package com.nexalyze.nexalyze.configuration.security.login.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenResponse {
    private String token;
    private String message;
    private String userFullName;
    private int languageId;

}
