package com.example.demo.model.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.example.demo.model.entity.Question;
import com.example.demo.model.entity.Quiz;

public interface QuestionRepo extends JpaRepositoryImplementation<Question, Long>{

    Set<Question> findByQuiz(Quiz quiz);
    
}
