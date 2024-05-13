package com.example.demo.repo;



import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.example.demo.models.User;

public interface UserRepository extends JpaRepositoryImplementation<User, Long> {
    
    public  User findByUsername(String userName);
}
