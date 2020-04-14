package com.rs.questiongenerator.service.impl;

import com.rs.questiongenerator.domain.GeneratedQuestionPaper;
import com.rs.questiongenerator.domain.Question;
import com.rs.questiongenerator.domain.TestQuestion;
import lombok.AllArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class JsonFormatGeneratorService {

    /**
     *
     * @param questions
     * @return
     */
    public GeneratedQuestionPaper generatedQuestionPaper (List<Question> questions) {
        GeneratedQuestionPaper generatedQuestionPaper = new GeneratedQuestionPaper();
        if (CollectionUtils.isNotEmpty(questions)) {
            List<TestQuestion> testQuestions = new ArrayList<>(questions.size());
            generatedQuestionPaper.setTotalNoOfQuestion(questions.size());
            for (Question question : questions) {
                testQuestions.add(createTestQuestion(question));
            }
            generatedQuestionPaper.setTestQuestions(testQuestions);
        }
        return generatedQuestionPaper;
    }

    /**
     *
     * @param question
     * @return
     */
    private TestQuestion createTestQuestion(Question question) {
        TestQuestion testQuestion = new TestQuestion();
        testQuestion.setQuestionId(question.getQuestionId());
        testQuestion.setQuestionDescription(question.getQuestionDescription());
        testQuestion.setQuestionNote(question.getQuestionNote());
        testQuestion.setQuestionHeader(question.getQuestionHeader());
        testQuestion.setQuestionOptions(question.getQuestionOptions());

        return testQuestion;
    }

}
