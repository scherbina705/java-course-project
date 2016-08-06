package com.stwitter.converter;

import org.dozer.DozerConverter;
import org.joda.time.LocalDateTime;

import java.util.Date;

/**
 * (c) Swissquote 8/5/16
 *
 * @author Shcherbina A.
 */
public class LocalDateTimeCustomConverter extends DozerConverter<LocalDateTime, Date> {

    public LocalDateTimeCustomConverter() {
        super(LocalDateTime.class, Date.class);
    }

    @Override
    public Date convertTo(final LocalDateTime source, final Date destination) {

        if (source == null) {
            return null;
        }

        return source.toDate();
    }

    @Override
    public LocalDateTime convertFrom(final Date source, final LocalDateTime destination) {

        if (source == null) {
            return null;
        }
        return new LocalDateTime(source);
    }

}