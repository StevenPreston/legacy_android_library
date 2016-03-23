package com.stellar16.stellar16.webservices;

import org.json.JSONException;
import org.json.JSONObject;

public class StellarRequestJSONResponse1 extends StellarRequest1
{
	public StellarRequestJSONResponse1(int id)
	{
		super(id);
	}
	
	
	protected boolean processResponseData(String response)
	{
		JSONObject responseDictionary = null;
		try
		{
			responseDictionary = new JSONObject(response);
			return processResponseDictionary(responseDictionary);
		}
		catch (JSONException e) {}
		
		return false; 
	}
	
	
	protected boolean processResponseDictionary(JSONObject responseDictionary)
	{
		return true;
	}
}
