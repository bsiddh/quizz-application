package com.telusko.Quizzapp.Questioncontroller;

import com.telusko.Quizzapp.dao.QuestionDao;
import com.telusko.Quizzapp.model.Question;
import com.telusko.Quizzapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionServices;
    @Autowired
    private QuestionDao questionDao;

    @GetMapping("/allQuestions")
    public List<Question> getAllQuestions(){
         return questionServices.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable String category){
        return questionDao.findByCategory(category);
    }

    @PostMapping("/add")
    public String addQuestion(@RequestBody Question question){
        return   questionServices.addQuestion(question);
    }


}
