package com.nexalyze.nexalyze.configuration.security.login.controller;

import com.nexalyze.nexalyze.configuration.security.login.model.LoginModel;
import com.nexalyze.nexalyze.configuration.security.login.model.TokenResponse;
import com.nexalyze.nexalyze.configuration.security.login.serivce.LoginService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
;

@RequestMapping("/auth")
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login (@RequestBody @Valid LoginModel loginModel){

        TokenResponse tokenResponse = loginService.login(loginModel);

        if (tokenResponse.getToken() == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(tokenResponse);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(tokenResponse);
    }

}
