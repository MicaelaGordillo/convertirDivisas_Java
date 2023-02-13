package com.example.convertirDivisas_Java.bl;

import com.example.convertirDivisas_Java.api.CurrencyApi;
import com.example.convertirDivisas_Java.dto.RequestServiceDto;
import com.example.convertirDivisas_Java.dto.ResponseServiceDto;
import com.example.convertirDivisas_Java.exception.CurrencyException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CurrencyBl {

    private Logger LOGGER = LoggerFactory.getLogger(CurrencyApi.class);

    public ResponseServiceDto exchangeRate (RequestServiceDto request){
        BigDecimal amountAux = request.getAmount();
        if(amountAux.compareTo(BigDecimal.ZERO) <= 0) {
            LOGGER.info("The amount that was entered is not valid.");
            throw new IllegalArgumentException("Sorry, the change could not be made. The amount entered must be greater than zero.");
        }
        LOGGER.info("Data amount: "+request.getAmount()+" from: "+request.getFrom()+" to: "+request.getTo());
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request requestApi = new Request.Builder()
            .url("https://api.apilayer.com/exchangerates_data/convert?to="+request.getTo()+"&from="+request.getFrom()+"&amount="+request.getAmount())
            .addHeader("apikey", "w0QJ1JH5U0UH7ZsTAMPvt4uKc76kPsvz")
            .method("GET", null)
            .build();

        try {
            Response response = client.newCall(requestApi).execute();
            LOGGER.info("External service");
            if(!response.isSuccessful()) {
                throw new CurrencyException("Error with the external service");
            }
            String body = response.body().string();

            ObjectMapper mapper = new ObjectMapper();
            ResponseServiceDto responseServiceDto = mapper.readValue(body, ResponseServiceDto.class);
            return responseServiceDto;
        } catch (Exception e) {
            LOGGER.error("Error with the external service", e);
            throw new CurrencyException("Error with the external service");
        }
    }
}
