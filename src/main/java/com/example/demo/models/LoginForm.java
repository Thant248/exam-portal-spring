package com.example.demo.models;

import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import jakarta.validation.constraints.NotBlank;

public record LoginForm(

    @NotBlank(message = "Please Enter UserName")
    String username,
    @NotBlank(message = "Please Enter Password")
    String password
) {

    public Authentication authentication(){
        return UsernamePasswordAuthenticationToken.unauthenticated(username, password);
    }
} 
