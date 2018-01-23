package com.chinaYouthHealth.payment.manager.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

public class JsonBigSerializer extends JsonSerializer<BigDecimal> {

    @Override
    public void serialize(BigDecimal aDouble, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException,
            JsonProcessingException {
        Currency c = Currency.getInstance(Locale.CHINA);
        jsonGenerator.writeString(String.format("%.2f",aDouble));
    }


}
