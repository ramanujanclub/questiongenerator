package com.rs.questiongenerator.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class QuestionCorrectAnswer implements Serializable {
    private List<CorrectAnswer> correctAnswers;
}
