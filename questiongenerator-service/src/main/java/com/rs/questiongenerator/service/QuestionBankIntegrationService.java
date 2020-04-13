package com.rs.questiongenerator.service;

import com.rs.questiongenerator.domain.Question;

import java.util.List;

public interface QuestionBankIntegrationService {
    List<Question> searchQuestionByClass(long classId);
}
