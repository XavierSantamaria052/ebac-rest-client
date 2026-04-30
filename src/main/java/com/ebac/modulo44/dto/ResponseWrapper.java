package com.ebac.modulo44.dto;

import org.springframework.http.ResponseEntity;

public class ResponseWrapper<T> {

    private ResponseEntity<T> responseEntity;

    public ResponseWrapper() {
    }

    public ResponseWrapper(ResponseEntity<T> responseEntity) {
        this.responseEntity = responseEntity;
    }

    public ResponseEntity<T> getResponseEntity() {
        return responseEntity;
    }

    public void setResponseEntity(ResponseEntity<T> responseEntity) {
        this.responseEntity = responseEntity;
    }
}
