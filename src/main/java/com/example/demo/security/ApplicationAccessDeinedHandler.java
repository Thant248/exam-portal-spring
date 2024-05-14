package com.example.demo.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerExceptionResolver;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class ApplicationAccessDeinedHandler implements AccessDeniedHandler {

    @Autowired
    private HandlerExceptionResolver handlerExceptionResolver;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
            AccessDeniedException accessDeniedException) throws IOException, ServletException {
        handlerExceptionResolver.resolveException(request, response, null, accessDeniedException);
    }
    
}