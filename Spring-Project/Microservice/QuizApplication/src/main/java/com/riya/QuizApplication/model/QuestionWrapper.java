package com.riya.QuizApplication.model;

import lombok.Data;

@Data
public class QuestionWrapper {
    private Integer question_id;

    private String questions;

    private String option1;
    private String option2;

    private String option3;

    private String option4;

    public QuestionWrapper(Integer question_id, String questions, String option1, String option2, String option3, String option4) {
        this.question_id = question_id;
        this.questions = questions;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
    }
}
