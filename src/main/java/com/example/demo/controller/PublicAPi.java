package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.LoginForm;
import com.example.demo.models.LoginResult;
import com.example.demo.security.TokenProvider;

@RestController
@RequestMapping("/public")
public class PublicAPi {
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider tokenProvider;

    @PostMapping("/login")
    public LoginResult login(@Validated LoginForm form, BindingResult result){
        
        var authentication = authenticationManager.authenticate(form.authentication());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        var token = tokenProvider.generate(authentication);

        if (null != token) {
            return new LoginResult(true, token);
        }
        return  new LoginResult(false, "Authentication Failure");
    }
    
}
