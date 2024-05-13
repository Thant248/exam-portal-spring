package com.example.demo.service;


import java.util.Set;


import com.example.demo.models.User;
import com.example.demo.models.UserRole;


public interface UserService {
    
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    public User getUserName(String username);

    public void deleteUser(Long id);

}
