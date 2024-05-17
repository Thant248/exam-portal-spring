package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.entity.Category;
import com.example.demo.model.entity.Question;
import com.example.demo.model.entity.Quiz;
import com.example.demo.model.service.QuestionService;
import com.example.demo.model.service.QuizService;

import java.util.List;
import java.util.Set;
import java.util.*;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/question")
public class QuestionApi {
    
    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuizService quizService;

    @PostMapping("/")
    public Question saveQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    @PutMapping("/")
    public Question updaQuestion(@RequestBody Question question){
        return questionService.updateQuestion(question);
    }


    @GetMapping("quiz/{qid}")
    public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("qid") Long qid){
       Quiz quiz = quizService.getQuizByid(qid);
        Set<Question> questions =  quiz.getQuestion();
        List<?> list = new ArrayList<>(questions);
        if (list.size() > Integer.parseInt(quiz.getNumberOfQuestions())) {
            
            list = list.subList(0, Integer.parseInt(quiz.getNumberOfQuestions() + 1));
        }
        Collections.shuffle(list);
        return ResponseEntity.ok(list);
    }


    @GetMapping("/")
    public List<Question> getAllQuestion(){
        return questionService.getAllQuestion();
    }

    //get single question 
    @GetMapping("/{qid}")
    public Question getOneQuestion(@PathVariable("qid") Long qid){
        return questionService.getQuestion(qid);
    }

    //delete question
    @DeleteMapping("/{qid}")
    public ResponseEntity<?> deleteQuestion(@PathVariable("qid") Long qid){
        questionService.deleteQuestion(qid);
        return ResponseEntity.ok("question has been successfully deleted");
    }


    @GetMapping("/active")
    public List<Quiz> getActiveQuizzes() {
        return  quizService.getActiveQuizzes();
    }

    @GetMapping("/category/active/{cid}")
    public List<Quiz> getActive(@PathVariable("cid") Long cid) {
        Category category = new Category();
        category.setCid(cid);
        return  quizService.getActiveQuizzesOFCategory(category);
    }


    





}
