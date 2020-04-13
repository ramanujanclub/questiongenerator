package com.rs.questiongenerator.domain;

import lombok.Data;

@Data
public class GeneratedQuestionPaper {
    private String questionDescription;
    private String questionHeader;
    private String questionNote;
    private QuestionOptions questionOptions;

}
