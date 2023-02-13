package com.example.convertirDivisas_Java.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class ResponseServiceDto {

    private Timestamp date;
    private InfoServiceDto info;
    private RequestServiceDto query;
    private BigDecimal result;
    private boolean success;

    public ResponseServiceDto() {
    }

    public ResponseServiceDto(Timestamp date, InfoServiceDto info, RequestServiceDto query, BigDecimal result, boolean success) {
        this.date = date;
        this.info = info;
        this.query = query;
        this.result = result;
        this.success = success;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public InfoServiceDto getInfo() {
        return info;
    }

    public void setInfo(InfoServiceDto info) {
        this.info = info;
    }

    public RequestServiceDto getQuery() {
        return query;
    }

    public void setQuery(RequestServiceDto query) {
        this.query = query;
    }

    public BigDecimal getResult() {
        return result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "ResponseServiceDto{" +
                "date=" + date +
                ", info=" + info +
                ", query=" + query +
                ", result=" + result +
                ", success=" + success +
                '}';
    }
}
