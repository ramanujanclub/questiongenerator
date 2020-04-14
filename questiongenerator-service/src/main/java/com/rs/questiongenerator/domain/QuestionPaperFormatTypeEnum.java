package com.rs.questiongenerator.domain;

public enum QuestionPaperFormatTypeEnum {

    QUESTION_PAPER_JSON_FORMAT("JSON"),
    QUESTION_PAPER_JSON_PDF("PDF");

    private final String formatType;

    QuestionPaperFormatTypeEnum(String formatType) {
        this.formatType = formatType;
    }

    @Override
    public String toString() {
        return formatType;
    }
}
