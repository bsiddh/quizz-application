package com.telusko.Quizzapp.service;

import com.telusko.Quizzapp.dao.QuestionDao;
import com.telusko.Quizzapp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

  public  List<Question> getAllQuestions(){
      return questionDao.findAll();
  }
  public String addQuestion(Question question){
      questionDao.save(question);
      return "success";
  }

}
