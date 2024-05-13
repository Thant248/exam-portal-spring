package com.example.demo.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.example.demo.models.Role;

public interface RoleRepository extends JpaRepositoryImplementation<Role, Long>{
    
}
