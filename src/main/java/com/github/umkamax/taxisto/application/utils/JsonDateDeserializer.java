package com.github.umkamax.taxisto.application.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class JsonDateDeserializer extends JsonDeserializer<Date>
{
	private final static SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");


	public JsonDateDeserializer() {}

	@Override
	public Date deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException
	{
		String dateString = jp.getText();
		try
		{
			return dateFormat.parse(dateString);
		}
		catch(Exception e)
		{
			Logger.getLogger(JsonDateDeserializer.class.getName()).log(Level.WARNING, "Cannot parse date[{}] by pattern[{}]. Reason[{}]: {}",
					new Object[]{dateString, dateFormat.toPattern(), e.getClass().toString(), e.getMessage()});
			return null;
		}
	}
}
