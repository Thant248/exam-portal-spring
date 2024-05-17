package com.example.demo.model.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.example.demo.model.entity.Category;
import com.example.demo.model.entity.Quiz;
import java.util.List;

public interface QuizRepo extends JpaRepositoryImplementation<Quiz, Long> {

    public List<Quiz> findByCategory(Category category);
    
    public List<Quiz>  findByActive(boolean active);

    public List<Quiz> findByCategoryAndActive(Category category, boolean active);

}
