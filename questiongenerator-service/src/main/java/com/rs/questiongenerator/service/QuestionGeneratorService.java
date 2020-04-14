package com.rs.questiongenerator.service;

import com.rs.questiongenerator.domain.GeneratedQuestionPaper;

public interface QuestionGeneratorService {
    GeneratedQuestionPaper generateQuestionPaperForClass(long classId);
}
