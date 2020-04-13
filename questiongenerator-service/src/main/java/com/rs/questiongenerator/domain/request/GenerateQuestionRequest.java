package com.rs.questiongenerator.domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenerateQuestionRequest {
    private int noOfQuestions;
    private Boolean duplicateAllowed;
    private String societyOrSchoolName;
    private String requestByUserId;
}
