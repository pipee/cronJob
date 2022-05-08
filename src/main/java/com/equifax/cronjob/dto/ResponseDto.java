package com.equifax.cronjob.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseDto {
    @JsonProperty("Response")
    private String response;

    public ResponseDto(String response) {
        this.response = response;
    }

    public ResponseDto() {
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "response='" + response + '\'' +
                '}';
    }
}
