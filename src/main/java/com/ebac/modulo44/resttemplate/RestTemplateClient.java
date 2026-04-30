package com.ebac.modulo44.resttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class RestTemplateClient {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.base.url}")
    private String baseUrl;

    public ResponseEntity<String> getUserById(Long id) {
        return restTemplate.getForEntity(baseUrl + "/users/" + id, String.class);
    }

    public ResponseEntity<String> createUser(String json) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(json, headers);
        return restTemplate.postForEntity(baseUrl + "/users", request, String.class);
    }
}