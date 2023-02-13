package com.example.convertirDivisas_Java.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.math.BigInteger;

public class InfoServiceDto {

    @JsonProperty("timestamp")
    private BigInteger timestamp;
    @JsonProperty("rate")
    private BigDecimal rate;

    public InfoServiceDto() {
    }

    public InfoServiceDto(BigInteger timestamp, BigDecimal rate) {
        this.timestamp = timestamp;
        this.rate = rate;
    }

    public BigInteger getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(BigInteger timestamp) {
        this.timestamp = timestamp;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "InfoDto{" +
                "timestamp=" + timestamp +
                ", rate=" + rate +
                '}';
    }
}
