package com.example.demo.model.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.example.demo.model.entity.Quiz;

public interface QuizRepo extends JpaRepositoryImplementation<Quiz, Long> {
    
}
