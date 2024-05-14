 package com.example.demo.security;

 import java.util.Collection;
 import java.util.HashSet;
 import java.util.Set;

 import com.example.demo.models.Authority;
 import org.springframework.security.core.GrantedAuthority;
 import org.springframework.security.core.userdetails.UserDetails;

 import com.example.demo.models.User;

 import lombok.RequiredArgsConstructor;

 @RequiredArgsConstructor
 public class SecurityUser implements UserDetails {

     private final User user;

     @Override
     public Collection<? extends GrantedAuthority> getAuthorities() {
         Set<Authority> set = new HashSet<>();
          user.getUserRole().forEach(userRole -> {
             set.add(new Authority(userRole.getRole().getRoleName()));
         });

          return set;
     }

     @Override
     public String getPassword() {
        return user.getPassword();
     }

     @Override
     public String getUsername() {
        return user.getUsername();
     }

     @Override
     public boolean isAccountNonExpired() {
         return true;
     }

     @Override
     public boolean isAccountNonLocked() {
        return true;
     }

     @Override
     public boolean isCredentialsNonExpired() {
         return true;
     }

     @Override
     public boolean isEnabled() {
         return true;
     }
    
 }
