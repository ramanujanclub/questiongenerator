package com.rs.questiongenerator.domain;

import lombok.Data;

@Data
public class TestQuestion {
    private String questionId;
    private String questionDescription;
    private String questionHeader;
    private String questionNote;
    private QuestionOptions questionOptions;
}
