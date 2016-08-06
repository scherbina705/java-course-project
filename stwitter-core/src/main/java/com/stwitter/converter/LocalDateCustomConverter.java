package com.stwitter.converter;

import java.util.Date;

import org.dozer.DozerConverter;
import org.joda.time.LocalDate;

/**
 * (c) Swissquote 8/5/16
 *
 * @author Shcherbina A.
 */
public class LocalDateCustomConverter extends DozerConverter<LocalDate, Date> {

	public LocalDateCustomConverter() {
		super(LocalDate.class, Date.class);
	}

	@Override
	public Date convertTo(final LocalDate source, final Date destination) {

		if (source == null) {
			return null;
		}

		return source.toDate();
	}

	@Override
	public LocalDate convertFrom(final Date source, final LocalDate destination) {

		if (source == null) {
			return null;
		}
		return new LocalDate(source);
	}

}