package com.rs.questiongenerator.service;

import com.rs.questiongenerator.domain.Question;

import java.util.List;

public interface QuestionGeneratorService {
    List<Question> generateQuestionPaperForClass(long classId);
}
