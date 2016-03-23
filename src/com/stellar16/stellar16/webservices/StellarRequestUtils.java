package com.stellar16.stellar16.webservices;

import java.util.Map;

public class StellarRequestUtils
{
	public static String getUrlWithUrlParameters(String url, Map<String, String> parameters)
	{
		//TODO: Complete
		return url;
	}
	
	
	public static String validate(String string)
	{
		if (string != null && !string.equals("null"))
		{
			return string;
		}
		else
		{
			return null;
		}
	}
}
