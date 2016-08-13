package com.stwitter.converter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdScalarSerializer;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.IOException;

/**
 * Created by Северская on 13.08.2016.
 */
public class CustomLocalDateTimeSerializer extends StdScalarSerializer<LocalDateTime> {

    private final static DateTimeFormatter DATE_FORMAT = DateTimeFormat.forPattern("yyyy-MM-dd");
    private final static DateTimeFormatter TIME_FORMAT = DateTimeFormat.forPattern("HH:mm:ss");

    public CustomLocalDateTimeSerializer() {
        super(LocalDateTime.class);
    }

    protected CustomLocalDateTimeSerializer(Class<LocalDateTime> t) {
        super(t);
    }

    @Override
    public void serialize(LocalDateTime value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
        jgen.writeStartObject();
        jgen.writeStringField("date", DATE_FORMAT.print(value));
        jgen.writeStringField("time", TIME_FORMAT.print(value));
        jgen.writeEndObject();
    }
}
