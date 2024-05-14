package com.example.demo.repo;



import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.example.demo.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepositoryImplementation<User, Long> {
    
    public  User findByUsername(String userName);

    Optional<User> findUserByUsername(String userName);
}
