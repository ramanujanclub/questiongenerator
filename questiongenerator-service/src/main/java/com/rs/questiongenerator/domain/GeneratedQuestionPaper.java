package com.rs.questiongenerator.domain;

import lombok.Data;

import java.util.List;

@Data
public class GeneratedQuestionPaper {
    private List<TestQuestion> testQuestions;
    private long totalNoOfQuestion;
    private QuestionPaperHeader questionPaperHeader;

}
