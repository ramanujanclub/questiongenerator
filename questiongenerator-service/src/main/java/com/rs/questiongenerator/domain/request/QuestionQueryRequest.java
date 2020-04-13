package com.rs.questiongenerator.domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionQueryRequest {
    private List<String> classIds;
    private List<String> chapterIds;
}
