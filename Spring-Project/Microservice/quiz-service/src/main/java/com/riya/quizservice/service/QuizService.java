package com.riya.quizservice.service;


import com.riya.quizservice.feign.QuizFeign;
import com.riya.quizservice.model.QuestionWrapper;
import com.riya.quizservice.dao.QuizDao;
import com.riya.quizservice.model.Quiz;
import com.riya.quizservice.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizDao quizDao;

    @Autowired
    private QuizFeign quizFeign;


    public ResponseEntity<String> createService(String category, int numQ, String title) {

        List<Integer> questionList = quizFeign.getQuestionsForQuiz(category, numQ).getBody();

        Quiz quiz = new Quiz();
        quiz.setQuestionList(questionList);
        quiz.setTitle(title);
        quizDao.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Quiz quiz = quizDao.findById(id).get();
        List<Integer> questionIds = quiz.getQuestionList();

        ResponseEntity<List<QuestionWrapper>> questions = quizFeign.getQuestions(questionIds);
        return questions;
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        ResponseEntity<Integer> score = quizFeign.getScore(responses);
        return score;

    }
}
