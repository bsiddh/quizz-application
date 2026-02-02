package com.telusko.Quizzapp.Questioncontroller;

import com.telusko.Quizzapp.service.QuestionService;
import com.telusko.Quizzapp.service.QuizServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizServices quizServices;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String title ){
          return quizServices.createQuiz(category,numQ,title);
    }
}
