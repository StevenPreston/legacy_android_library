package com.stellar16.stellar16.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class StellarConversionUtils
{
	public static Calendar getDateFromString(String string, String format)
	{
		Calendar calendar = null;

		SimpleDateFormat form = new SimpleDateFormat(format, Locale.US);
		Date date = null;
		
		try
		{
			date = form.parse(string);
			
			calendar = Calendar.getInstance();
			calendar.setTime(date);
		}
		catch (java.text.ParseException e)
		{
		}
		
		return calendar;
	}
	
	
	public static String getStringFromDate(Calendar date, String format)
	{
		String string;
		
		SimpleDateFormat form = new SimpleDateFormat(format, Locale.US);
		string = form.format(date.getTime());
		
		return string;
	}
}
