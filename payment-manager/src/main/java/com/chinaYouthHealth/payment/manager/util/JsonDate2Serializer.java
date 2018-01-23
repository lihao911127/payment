package com.chinaYouthHealth.payment.manager.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonDate2Serializer extends JsonSerializer<Date> {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    //    private String patten;
    //
    //    public JsonDate2Serializer(String patten) {
    //        this.dateFormat = new SimpleDateFormat(patten);
    //    }

    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        String value = dateFormat.format(date);
        jsonGenerator.writeString(value);
    }
}
