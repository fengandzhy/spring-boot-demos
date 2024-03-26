package org.frank.spring.boot.time.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class CustomLocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext context) throws IOException {
        String valueAsString = p.getValueAsString();
        try {
            return LocalDateTime.parse(valueAsString, formatter);
        } catch (DateTimeParseException e) {
            LocalDate date = LocalDate.parse(valueAsString, dateFormatter);
            return date.atStartOfDay(); // 或者date.atTime(LocalTime.MIN)以保留日期部分，时间设置为00:00:00
        }
    }
}
