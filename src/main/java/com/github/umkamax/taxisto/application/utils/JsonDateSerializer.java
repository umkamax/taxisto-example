package com.github.umkamax.taxisto.application.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonDateSerializer extends JsonSerializer<Date>
{
	private final static DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

	public JsonDateSerializer() {}

	@Override
	public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider) throws IOException
	{
		String dateString = null;

		if (value != null)
			dateString = dateFormat.format(value);

		jgen.writeString(dateString);
	}
}
