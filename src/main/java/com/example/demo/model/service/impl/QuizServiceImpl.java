package com.example.demo.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        quizRepo.deleteById(quizId);
    }
    
}
