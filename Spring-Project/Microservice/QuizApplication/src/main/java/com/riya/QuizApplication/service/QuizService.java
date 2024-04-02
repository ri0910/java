package com.riya.QuizApplication.service;


import com.riya.QuizApplication.dao.Questiondao;
import com.riya.QuizApplication.dao.QuizDao;
import com.riya.QuizApplication.model.Question;
import com.riya.QuizApplication.model.QuestionWrapper;
import com.riya.QuizApplication.model.Quiz;
import com.riya.QuizApplication.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuizDao quizDao;

    @Autowired
    private Questiondao questiondao;


    public ResponseEntity<String> createService(String category, int numQ, String title) {

        List<Question> questionList = questiondao.findRandomQuestionsByCategory(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionList(questionList);
        quizDao.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questionFromDB = quiz.get().getQuestionList();
        List<QuestionWrapper> questionWrappers = new ArrayList<>();

        for(Question q:questionFromDB) {
            QuestionWrapper qw = new QuestionWrapper(q.getQuestion_id(), q.getQuestions(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            questionWrappers.add(qw);
        }

        return new ResponseEntity<>(questionWrappers, HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questions = quiz.get().getQuestionList();
        int right = 0;
        int i = 0;

        for(Response r : responses) {
            if(r.getResponse().equals(questions.get(i).getAnswer())) {
                right++;
            }
            i++;
        }
        return new ResponseEntity<>(right, HttpStatus.OK);

    }
}
