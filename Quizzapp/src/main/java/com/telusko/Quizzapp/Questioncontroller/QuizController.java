package com.telusko.Quizzapp.Questioncontroller;

import com.telusko.Quizzapp.model.Question;
import com.telusko.Quizzapp.model.QuestionWrapper;
import com.telusko.Quizzapp.service.QuestionService;
import com.telusko.Quizzapp.service.QuizServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizServices quizServices;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String title ){
          return quizServices.createQuiz(category,numQ,title);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
      return  quizServices.getQuizQuestions(id);
    }
}
