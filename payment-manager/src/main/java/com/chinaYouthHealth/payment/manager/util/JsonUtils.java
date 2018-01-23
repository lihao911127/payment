package com.chinaYouthHealth.payment.manager.util;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;

/**
 * @author: <a herf="matilto:jarodchao@126.com>jarod </a>
 */
public class JsonUtils {

    private static final Log logger = LogFactory.getLog(JsonUtils.class);

    private static final ObjectMapper mapper = new ObjectMapper();

    public static String toJson(Object obj) {

        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        try {
            return ow.writeValueAsString(obj);
        } catch (IOException e) {
            logger.error("Error when converting a json object to a string. " + e.getMessage());
            return "";
        }
    }

    public static <T extends Object> T toObject(String json, Class<T> clazz) {
        Object object = null;
        try {

            object = mapper.readValue(json, clazz);
        } catch (JsonParseException e) {
            logger.error("JsonParseException when serialize object to json", e);
        } catch (JsonMappingException e) {
            logger.error("JsonMappingException when serialize object to json", e);
        } catch (IOException e) {
            logger.error("IOException when serialize object to json", e);
        }
        return (T) object;

    }

    public static boolean isValid(String json) {
        boolean retValue = true;
        try {
            mapper.enable(DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY);
            JsonFactory factory = mapper.getFactory();
            JsonParser parser = factory.createParser(json);
            mapper.readTree(parser);
        } catch (JsonParseException jpe) {
            retValue = false;
        } catch (IOException ioe) {
            retValue = false;
        }
        return retValue;
    }

}
