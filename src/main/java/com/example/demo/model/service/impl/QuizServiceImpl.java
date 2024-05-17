package com.example.demo.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.entity.Category;
import com.example.demo.model.entity.Quiz;
import com.example.demo.model.repo.QuizRepo;
import com.example.demo.model.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepo quizRepo;

    @Override
    public Quiz addQuiz(Quiz quiz) {
        return quizRepo.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
       return quizRepo.save(quiz);
    }

    @Override
    public List<Quiz> getAllQuezz() {
        return quizRepo.findAll();   
    }

    @Override
    public Quiz getQuizByid(Long quizId) {
     return  quizRepo.findById(quizId).get();
    }

    @Override
    public void deleteQuizById(Long quizId) {
        Quiz quiz = new Quiz();
        quiz.setQid(quizId);
        quizRepo.delete(quiz);
    }

    @Override
    public List<Quiz> getQuizzesOfCategory(Category category) {
        return quizRepo.findByCategory(category);
    }

    @Override
    public List<Quiz> getActiveQuizzes() {
       return quizRepo.findByActive(true);
    }

    @Override
    public List<Quiz> getActiveQuizzesOFCategory(Category category) {
        return quizRepo.findByCategoryAndActive(category, true);
    }
    
}
