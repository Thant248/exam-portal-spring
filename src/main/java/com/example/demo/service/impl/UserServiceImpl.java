package com.example.demo.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.User;
import com.example.demo.models.UserRole;
import com.example.demo.repo.RoleRepository;
import com.example.demo.repo.UserRepository;
import com.example.demo.service.UserService;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception   {

       User local =  userRepository.findByUsername(user.getUsername());

       if (local != null) {
            System.out.println("User is already there !");
            throw new Exception("User already present!!");
       }else{

            for(UserRole ur : userRoles){
            
                roleRepository.save(ur.getRole());
            }

            user.getUserRole().addAll(userRoles);
            local = userRepository.save(user);

       }

       return local;
        
    }

    @Override
    public User getUserName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
