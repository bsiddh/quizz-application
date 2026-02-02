package com.telusko.Quizzapp.dao;

import com.telusko.Quizzapp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz,Integer> {

}
