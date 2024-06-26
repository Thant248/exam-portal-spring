package com.example.demo.model.service;

import com.example.demo.model.entity.Category;
import com.example.demo.model.entity.Quiz;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface QuizService {
    public Quiz addQuiz(Quiz quiz);

    public Quiz updateQuiz(Quiz quiz);

    public List<Quiz> getAllQuezz();

    public Quiz getQuizByid(Long quizId);

    public void deleteQuizById(Long quizId);

    public List<Quiz> getQuizzesOfCategory(Category category);
    
    public List<Quiz> getActiveQuizzes();

    public List<Quiz> getActiveQuizzesOFCategory(Category category);
}
