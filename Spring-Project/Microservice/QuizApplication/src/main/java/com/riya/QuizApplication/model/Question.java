package com.riya.QuizApplication.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer question_id;

    private String questions;

    private String difficulty_level;

    private String category;

    private String option1;


    private String option2;

    private String option3;

    private String option4;

    private String answer;
}
