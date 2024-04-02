package com.riya.QuizApplication.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Response {
    private Integer question_id;
    private String response;
}
