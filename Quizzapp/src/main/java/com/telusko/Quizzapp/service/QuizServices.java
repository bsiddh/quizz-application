package com.telusko.Quizzapp.service;

import com.telusko.Quizzapp.dao.QuestionDao;
import com.telusko.Quizzapp.dao.QuizDao;
import com.telusko.Quizzapp.model.Question;
import com.telusko.Quizzapp.model.QuestionWrapper;
import com.telusko.Quizzapp.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizServices {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title){

        List<Question> questions = questionDao.findRandomQuestionsByCategory(category,numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);
        return ResponseEntity.ok("Quiz created successfully");


    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id){
      Optional<Quiz> quiz = quizDao.findById(id);
      List<Question> questionFromDB = quiz.get().getQuestions();
      List<QuestionWrapper> questionForUser= new ArrayList<>();
      for (Question q : questionFromDB){
          QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
          questionForUser.add(qw);
      }

      return new ResponseEntity<>(questionForUser,HttpStatus.OK);
    }
}
