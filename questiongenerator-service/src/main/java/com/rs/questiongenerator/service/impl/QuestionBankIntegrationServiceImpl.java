package com.rs.questiongenerator.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rs.questiongenerator.domain.Question;
import com.rs.questiongenerator.domain.QuestionSearchQuery;
import com.rs.questiongenerator.domain.SearchQuestionRequest;
import com.rs.questiongenerator.service.QuestionBankIntegrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class QuestionBankIntegrationServiceImpl implements QuestionBankIntegrationService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${questionbank.searchquestion.url}")
    private String searchQuestionURL;

    @Override
    public List<Question> searchQuestionByClass(long classId) {
        try {
            HttpHeaders headers = buildHttpHeader();
            QuestionSearchQuery questionSearchQuery = new QuestionSearchQuery();
            questionSearchQuery.setClassId(classId);
            SearchQuestionRequest searchQuestionRequest = new SearchQuestionRequest();
            searchQuestionRequest.setQuestionSearchQuery(questionSearchQuery);
            HttpEntity<SearchQuestionRequest> request = new HttpEntity<>(searchQuestionRequest,headers);

            URI uri = UriComponentsBuilder.fromHttpUrl(searchQuestionURL).build().toUri();
            ResponseEntity<List<Question>> searchQuestionResponse =
                    restTemplate.exchange(uri, HttpMethod.POST, request, new ParameterizedTypeReference<List<Question>>() {});

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            System.out.println("Response :"+objectMapper.writeValueAsString(searchQuestionResponse.getBody()));
            return searchQuestionResponse.getBody();
        } catch (HttpClientErrorException httpClientException) {
            httpClientException.printStackTrace();
        } catch (JsonProcessingException jsonException) {
            jsonException.printStackTrace();
        }
        return Collections.emptyList();
    }


    private HttpHeaders buildHttpHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));


        return headers;
    }
}
