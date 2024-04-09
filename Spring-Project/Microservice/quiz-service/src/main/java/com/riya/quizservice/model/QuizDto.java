package com.riya.quizservice.model;


import lombok.Data;

@Data
public class QuizDto {
    String categoryName;
    Integer numOfQuestions;
    String title;
}
