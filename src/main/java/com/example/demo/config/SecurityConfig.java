 package com.example.demo.config;

 import com.example.demo.exceptions.CustomAccessDeniedHandler;
 import com.example.demo.security.JwtTokenAuthenticationFilter;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 import org.springframework.security.authentication.AuthenticationManager;
 import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
 import org.springframework.security.config.annotation.web.builders.HttpSecurity;
 import org.springframework.security.config.http.SessionCreationPolicy;
 import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 import org.springframework.security.crypto.password.PasswordEncoder;
 import org.springframework.security.web.SecurityFilterChain;
 import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


 @Configuration
 public class SecurityConfig {


     @Autowired
    private CustomAccessDeniedHandler customAccessDeniedHandler;

     @Autowired
     private JwtTokenAuthenticationFilter jwtTokenAuthenticationFilter;

     @Bean
     public PasswordEncoder passwordEncoder(){
         return  new BCryptPasswordEncoder();
     }

     @Bean
     public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws  Exception{
         return  authenticationConfiguration.getAuthenticationManager();
     }

     @Bean
     public SecurityFilterChain http(HttpSecurity http) throws Exception{
        http.csrf(csrf -> csrf.disable());
        http.cors(cors -> {});
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.exceptionHandling(handler -> handler.accessDeniedHandler(customAccessDeniedHandler));

        http.authorizeHttpRequests(request -> {
            request.requestMatchers("/public/**").permitAll();
            request.requestMatchers("/users/**").permitAll();
        });

        http.addFilterBefore(jwtTokenAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
     }
 }
