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
import com.example.demo.model.entity.Quiz;
import com.example.demo.model.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizApi {
    
    @Autowired
    private QuizService quizService;

    //add quiz
    @PostMapping("/")
    public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz){
        
        return ResponseEntity.ok(quizService.addQuiz(quiz));

    }

    //update quizz
    @PutMapping("/")
    public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz){
       return  ResponseEntity.ok(quizService.updateQuiz(quiz));
    }

    //get quiz 
    @GetMapping("/")
    public ResponseEntity<?> getQuizes(){
        return ResponseEntity.ok(quizService.getAllQuezz());
    }

    //get quiz by id
    @GetMapping("/{quizId}")
    public ResponseEntity<?> getQuizesById(@PathVariable("quizId") Long quizId){
        return ResponseEntity.ok(quizService.getQuizByid(quizId));
    }


    //delete quiz
    @DeleteMapping("/{qid}")
    public  String deleteQuiz(@PathVariable("qid") Long qid){
        
         quizService.deleteQuizById(qid);
         return "Quiz has been deleted";
    }

    


}
