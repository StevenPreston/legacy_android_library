package com.stellar16.stellar16.webservices;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.apache.http.entity.StringEntity;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class StellarRequest
{
	protected StellarRequestDelegate delegate;
	protected Object processingResult;
	protected int id;
	protected int type;
	protected String urlString;
	protected String requestType;
	protected String postData;
	protected Map<String, String> postDataValuesAndKeys;
	protected String contentType;
	protected Map<String, String> urlParameters;

	
	//Constructors
	
	public StellarRequest(int id)
	{
		this.id = id;
	}

	
	//Request Methods

	protected void createRequest()
	{
		String urlWithParameters = StellarRequestUtils.getUrlWithUrlParameters(urlString, urlParameters);

		StellarRequestManager requestManager = StellarRequestManager.getInstance();
		AsyncHttpClient client = requestManager.getClient();		
		StellarRequestContext context = requestManager.getContext(id, type);
		
		AsyncHttpResponseHandler responseHandler = new AsyncHttpResponseHandler()
		{
			public void onSuccess(String response)
			{
				if (delegate != null)
				{
					//Pass the data to the subclass to be handled specifically.
					if (response == null)
					{
						delegate.generalError(StellarRequest.this, processingResult);
						return;
					}

					boolean processingSuccess;
					try
					{
						//Call to "protected" method implemented by subclass.
						processingSuccess = processResponseData(response);
					}
					catch (Exception exception)
					{
						processingSuccess = false;
					}

					if (processingSuccess)
					{
						if (delegate != null)
						{
							delegate.result(StellarRequest.this, processingResult);
						}
					}
					else
					{
						if (delegate != null)
						{
							delegate.generalError(StellarRequest.this, processingResult);
						}
					}
				}
			}

			public void onFailure(Throwable e, String response)
			{
				if (delegate != null)
				{
					delegate.connectionError(StellarRequest.this, response);
				}
			}
		};
		
		if (requestType != null && requestType.equals("POST"))
		{
			if (postData != null)
			{
				StringEntity postDataEntity = null;
				
				try
				{
					postDataEntity = new StringEntity(postData);
				}
				catch (UnsupportedEncodingException e1) {}
				
				client.post(context, urlWithParameters, postDataEntity, contentType, responseHandler);
			}
			else
			{
				RequestParams requestParams = new RequestParams(postDataValuesAndKeys);
				client.post(context, urlWithParameters, requestParams, responseHandler);
			}
		}
		else
		{
			client.get(context, urlWithParameters, responseHandler);
		}
	}

	
	protected boolean processResponseData(String responseData)
	{
		processingResult = responseData;
		return true;
	}

	
	// Getter and Setter Methods

	public void setDelegate(StellarRequestDelegate delegate)
	{
		this.delegate = delegate;
	}
	
	public void setType(int type)
	{
		this.type = type;
	}
	
	public int getType()
	{
		return type;
	}
	
	public Object getProcessingResult()
	{
		return processingResult;
	}

	public int getId()
	{
		return id;
	}
}
