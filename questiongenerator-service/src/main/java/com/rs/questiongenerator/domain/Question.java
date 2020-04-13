package com.rs.questiongenerator.domain;

import lombok.Data;

@Data
public class Question {
    private String questionId;
    private String parentQuestionId;
    private String questionDescription;
    private String questionHeader;
    private String questionNote;
    private byte[] questionDescriptionImage;
    private byte[] scannedQuestionImage;
    private QuestionOptions questionOptions;
    private QuestionCorrectAnswer questionCorrectAnswer;
    private long chapterId;
    private long classId;
    private String questionComplexityLevel;
    private QuestionMetaData questionMetadata;
    private QuestionHint questionHint;
    private QuestionStatus questionStatus;

}
