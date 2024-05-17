package com.example.demo.model.service;


import com.example.demo.model.entity.Question;
import com.example.demo.model.entity.Quiz;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public interface QuestionService {
    
    public Question addQuestion(Question question);

    public Question updateQuestion(Question question);

    public List<Question> getAllQuestion();

    public Question getQuestion(Long questionId);

    public Set<Question> getQuestionsOfQuiz(Quiz quiz);

    public void deleteQuestion(Long qid);

}
