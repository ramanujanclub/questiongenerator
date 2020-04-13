package com.rs.questiongenerator.service.impl;

import com.rs.questiongenerator.domain.Question;
import com.rs.questiongenerator.service.QuestionBankIntegrationService;
import com.rs.questiongenerator.service.QuestionGeneratorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class QuestionGeneratorServiceImpl implements QuestionGeneratorService {

    private QuestionBankIntegrationService questionBankIntegrationService;

    @Override
    public List<Question> generateQuestionPaperForClass(long classId) {
        return questionBankIntegrationService.searchQuestionByClass(classId);
    }
}
