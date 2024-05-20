package com.example.demo.model.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.entity.Question;
import com.example.demo.model.entity.Quiz;
import com.example.demo.model.repo.QuestionRepo;
import com.example.demo.model.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    private QuestionRepo uQuestionRepo;

    @Override
    public Question addQuestion(Question question) {
       return  uQuestionRepo.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return uQuestionRepo.save(question);
    }

    @Override
    public List<Question> getAllQuestion() {
       return uQuestionRepo.findAll();
    }

    @Override
    public Question getQuestion(Long questionId) {
        return uQuestionRepo.findById(questionId).get();
    }

    @Override
    public Set<Question> getQuestionsOfQuiz(Quiz quiz) {
        return uQuestionRepo.findByQuiz(quiz);
    }

    @Override
    public void deleteQuestion(Long qid) {
        Question question = new Question();
        question.setId(qid);
        uQuestionRepo.delete(question);
    }

    @Override
    public Question get(Long quesid) {
        return uQuestionRepo.getOne(quesid);
    }
    
}
