 package com.example.demo.security;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.security.core.userdetails.UserDetails;
 import org.springframework.security.core.userdetails.UserDetailsService;
 import org.springframework.security.core.userdetails.UsernameNotFoundException;
 import org.springframework.stereotype.Service;

 import com.example.demo.repo.UserRepository;

 import jakarta.persistence.EntityNotFoundException;

 @Service
 public class CustomUserDetailsService  implements UserDetailsService{

     @Autowired
     private UserRepository userRepository;

     @Override
     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         return userRepository.findUserByUsername(username).map(SecurityUser::new).orElseThrow(() -> new EntityNotFoundException("username not found"));
     }
    
 }
