package com.example.convertirDivisas_Java.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorServiceDto<T> {

    @JsonProperty("code")
    private String code;
    @JsonProperty("message")
    private String message;

    public ErrorServiceDto() {
    }

    public ErrorServiceDto(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ErrorServiceDto{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
