package com.example.demo.security;

import com.example.demo.repo.UserRepository;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AppAuthenticationProvider extends DaoAuthenticationProvider {

    public AppAuthenticationProvider(PasswordEncoder passwordEncoder, UserRepository repo) {
        super(passwordEncoder);
        setUserDetailsService(username -> repo.findUserByUsername(username)
                .map(a -> User.withUsername(username)
                        .password(a.getPassword())
                        .authorities(a.getUsername())
                        .build())
                .orElseThrow(() -> new UsernameNotFoundException(username))
        );
        setHideUserNotFoundExceptions(false);
    }
}
