package com.rs.questiongenerator.controller;

import com.rs.questiongenerator.domain.GeneratedQuestionPaper;
import com.rs.questiongenerator.service.QuestionGeneratorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/questiongenerator", produces = {MediaType.APPLICATION_JSON_VALUE})
@Slf4j
@AllArgsConstructor
public class QuestionGeneratorController {

    private QuestionGeneratorService questionGeneratorService;

    @GetMapping("health")
    public ResponseEntity checkHealth() {
        return new ResponseEntity("Service is healthy.", HttpStatus.OK);
    }

    @GetMapping("questionpaper")
    public ResponseEntity<GeneratedQuestionPaper> searchQuestions(@RequestParam(value = "classId") String classId) {
        log.info("Request received for generating question paper for classIds : [{}] ", classId);
        GeneratedQuestionPaper testQuestionPaper = questionGeneratorService.generateQuestionPaperForClass(Long.parseLong(classId));
        return new ResponseEntity<>(testQuestionPaper, HttpStatus.OK);
    }
}
