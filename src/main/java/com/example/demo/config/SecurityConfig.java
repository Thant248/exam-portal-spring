 package com.example.demo.config;

 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.security.ApplicationAccessDeinedHandler;
import com.example.demo.security.TokenFilter;
 

 @Configuration
 @EnableWebSecurity
 public class SecurityConfig {

    @Autowired
    private TokenFilter tokenFilter;

    @Autowired
    private ApplicationAccessDeinedHandler applicationAccessDeinedHandler;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http.csrf(csrf -> csrf.disable());
        http.cors(cors -> {});
        http.authorizeHttpRequests(req -> {
            req.requestMatchers("/public/**").permitAll();
            req.requestMatchers("/user/**").permitAll();
            
        });

        http.addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class);
        http.exceptionHandling(exception -> exception.accessDeniedHandler(applicationAccessDeinedHandler));
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();

    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        var bean = new DaoAuthenticationProvider();

        bean.setUserDetailsService(userDetailsService());
        bean.setHideUserNotFoundExceptions(false);

        return bean;

    }
    

    private UserDetailsService userDetailsService(){

        return new InMemoryUserDetailsManager(
            User.withUsername("admin@gmail.com").authorities("ADMIN").password("{noop}admin").build(),
            User.withUsername("member@gmail.com").authorities("NORMAL").password("{noop}member").build()
        );
    }
    
 }
