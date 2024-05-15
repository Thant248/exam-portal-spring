package com.example.demo.controller;


import com.example.demo.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.UserService;

import java.util.HashSet;
import java.util.Set;


@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired  
    private UserService userService;


    
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {

        try {
            Set<UserRole> userRoles = new HashSet<>();

        Role role  = new Role();
        role.setRoleId(44L);
        role.setRoleName("NORMAL");


        UserRole userRole = new UserRole();
        userRole.setRole(role);
        userRole.setUser(user);

        userRoles.add(userRole);    
        User createdUser =  userService.createUser(user, userRoles);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){
        return userService.getUserName(username);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") Long id){
        userService.deleteUser(id);
    }


}
