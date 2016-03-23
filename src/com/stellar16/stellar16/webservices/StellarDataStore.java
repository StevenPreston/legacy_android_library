package com.stellar16.stellar16.webservices;

import java.util.HashMap;

import com.stellar16.stellar16.base.NotificationController;

public class StellarDataStore implements StellarRequestDelegate, StellarRequestDelegate1
{
	public static String NOTIFICATION_REQUEST = "NOTIFICATION_REQUEST";
	public static int NOTIFICATION_REQUEST_RESULT_SUCCESS = 0;
	public static int  NOTIFICATION_REQUEST_RESULT_CONNECTION_ERROR = 1;
	public static int  NOTIFICATION_REQUEST_RESULT_GENERAL_ERROR = 2;
	public static int  NOTIFICATION_REQUEST_RESULT_HTTP_ERROR = 3;
	
	
	//Request Helper Methods

	public void cancelRequests(int id)
	{
		StellarRequestManager requestManager = StellarRequestManager.getInstance();
		requestManager.cancelRequests(id);
	}
	
	
	public void cancelRequests(int id, int type)
	{
		StellarRequestManager requestManager = StellarRequestManager.getInstance();
		requestManager.cancelRequests(id, type);
	}
	
	
	//Request Notification Methods

	protected void notifyWithRequest(StellarRequest request, int result)
	{
		HashMap<String, Object>userInfo = new HashMap<String, Object>();
		
		if (request != null)
		{
			userInfo.put(NOTIFICATION_REQUEST, request);
		}
		
		userInfo.put(NotificationController.NOTIFICATION_RESULT, Integer.valueOf(result));
		NotificationController.getInstance().postNotification(NOTIFICATION_REQUEST, null, userInfo);
	}
	
	
	protected void notifyWithRequest(StellarRequest1 request, int result)
	{
		HashMap<String, Object>userInfo = new HashMap<String, Object>();
		
		if (request != null)
		{
			userInfo.put(NOTIFICATION_REQUEST, request);
		}
		
		userInfo.put(NotificationController.NOTIFICATION_RESULT, Integer.valueOf(result));
		NotificationController.getInstance().postNotification(NOTIFICATION_REQUEST, null, userInfo);
	}
	
	
	//StellarRequestDelegate Methods
	
	@Override
	public void result(StellarRequest request, Object result)
	{
		notifyWithRequest(request, NOTIFICATION_REQUEST_RESULT_SUCCESS);
	}
	
	
	@Override
	public void connectionError(StellarRequest request, Object result)
	{
		notifyWithRequest(request, NOTIFICATION_REQUEST_RESULT_CONNECTION_ERROR);
	}
	
	
	@Override
	public void generalError(StellarRequest request, Object result)
	{
		notifyWithRequest(request, NOTIFICATION_REQUEST_RESULT_GENERAL_ERROR);
	}
	
	
	@Override
	public void httpError(StellarRequest request, Object result, int errorCode, String errorMessage)
	{
		generalError(request, result);
	}


	@Override
	public void result(StellarRequest1 request, Object result)
	{
		notifyWithRequest(request, NOTIFICATION_REQUEST_RESULT_SUCCESS);
	}


	@Override
	public void connectionError(StellarRequest1 request, Object result)
	{
		notifyWithRequest(request, NOTIFICATION_REQUEST_RESULT_CONNECTION_ERROR);
	}


	@Override
	public void generalError(StellarRequest1 request, Object result)
	{
		notifyWithRequest(request, NOTIFICATION_REQUEST_RESULT_GENERAL_ERROR);
	}


	@Override
	public void httpError(StellarRequest1 request, Object result, int errorCode, String errorMessage)
	{
		generalError(request, result);
	}
}
