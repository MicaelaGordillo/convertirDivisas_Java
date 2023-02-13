package com.example.convertirDivisas_Java.dto;

import java.math.BigDecimal;

public class RequestServiceDto {

    private BigDecimal amount;
    private String to;
    private String from;

    public RequestServiceDto() {
    }

    public RequestServiceDto(BigDecimal amount, String to, String from) {
        this.amount = amount;
        this.to = to;
        this.from = from;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    @Override
    public String toString() {
        return "RequestServiceDto{" +
                "amount=" + amount +
                ", to='" + to + '\'' +
                ", from='" + from + '\'' +
                '}';
    }
}
