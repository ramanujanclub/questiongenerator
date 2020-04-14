package com.rs.questiongenerator.service.impl;

import com.rs.questiongenerator.domain.GeneratedQuestionPaper;
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
    private JsonFormatGeneratorService jsonFormatGeneratorService;
    private PDFFormatGeneratorService pdfFormatGeneratorService;

    @Override
    public GeneratedQuestionPaper generateQuestionPaperForClass(long classId) {
        List<Question> questionList =  questionBankIntegrationService.searchQuestionByClass(classId);
        pdfFormatGeneratorService.generatedQuestionPaper(questionList);
        return jsonFormatGeneratorService.generatedQuestionPaper(questionList);
    }
}
