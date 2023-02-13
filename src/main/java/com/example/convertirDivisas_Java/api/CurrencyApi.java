package com.example.convertirDivisas_Java.api;

import com.example.convertirDivisas_Java.bl.CurrencyBl;
import com.example.convertirDivisas_Java.dto.RequestServiceDto;
import com.example.convertirDivisas_Java.dto.ResponseServiceDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/currency")
public class CurrencyApi {

    private CurrencyBl currencyBl;
    private Logger LOGGER = LoggerFactory.getLogger(CurrencyApi.class);

    public CurrencyApi(CurrencyBl currencyBl) {
        this.currencyBl = currencyBl;
    }

    @GetMapping("/exchange")
    public ResponseServiceDto exchangeRate (
        @RequestParam BigDecimal amount,
        @RequestParam String from,
        @RequestParam String to
    ){
        RequestServiceDto requestServiceDto = new RequestServiceDto(amount, from, to);
        LOGGER.info("Processing conversion request amount: "+amount+" from: "+from+" to: "+to);
        ResponseServiceDto responseServiceDto = currencyBl.exchangeRate(requestServiceDto);
        return responseServiceDto;
    }

}
