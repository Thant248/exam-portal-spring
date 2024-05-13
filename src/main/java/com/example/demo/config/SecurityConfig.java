 package com.example.demo.config;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;
 import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
 import org.springframework.security.config.Customizer;
 import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
 import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
 import org.springframework.security.config.annotation.web.builders.HttpSecurity;
 import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
 import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
 import org.springframework.security.config.http.SessionCreationPolicy;
 import org.springframework.security.core.userdetails.UserDetailsService;
 import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 import org.springframework.security.crypto.password.PasswordEncoder;
 import org.springframework.security.web.SecurityFilterChain;
 import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

 @Configuration
 @EnableWebSecurity
 public class SecurityConfig {

     @Autowired
     private UserDetailsService userDetailsService;

     @Autowired
     private  JwtAuthenticationEntryPoint unauthorizedHandler;

     @Bean
     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(Customizer.withDefaults())
                .authorizeHttpRequests(t -> t.requestMatchers("/generate-token", "/user/").permitAll().anyRequest().authenticated())
                .exceptionHandling(e -> e.authenticationEntryPoint(unauthorizedHandler))
                .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
     }

     @Bean
     public DaoAuthenticationProvider daoAuthenticationProvider(){
         DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
         provider.setUserDetailsService(userDetailsService);
         provider.setPasswordEncoder(passwordEncoder());
         return provider;
     }

    
     @Bean
     public PasswordEncoder passwordEncoder(){
         return new BCryptPasswordEncoder();
     }

 }
