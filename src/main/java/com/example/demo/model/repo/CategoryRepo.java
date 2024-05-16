package com.example.demo.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Long>{
    
}
