package com.rs.questiongenerator.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class QuestionMetaData implements Serializable {

    private String name;
    private String value;
}
