package com.riya.QuizApplication.dao;

import com.riya.QuizApplication.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz, Integer> {
}
