package com.stellar16.stellar16.webservices;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import android.os.AsyncTask;

import com.stellar16.stellar16.webservices.StellarMultipartEntity.ProgressListener;


public abstract class StellarRequest1 extends AsyncTask<Void, Integer, Boolean>
{
	private static int PROGRESS_MAX = 100;
	
	protected StellarRequestDelegate1 delegate;
	protected StellarRequestProgressDelegate progressDelegate;
	protected int id;
	protected int type;
	protected String urlString;
	protected ArrayList<NameValuePair> postDataValuesAndKeys;
	protected ArrayList<StellarKeyValuePair<String, File>> files;
	private long totalSize;
	
	protected Object processingResult;
	protected HttpResponse response;
	
	
	//Constructors
	
	public StellarRequest1(int id)
	{
		this.id = id;
	}
	
	
	protected void addFileParts(StellarMultipartEntity multipartContent)
	{
		for (StellarKeyValuePair<String, File> pair : files)
		{
			if (isCancelled()) return;
			
			multipartContent.addPart(pair.getKey(), new FileBody(pair.getValue()));
		}
	}
	
	
	@Override
	protected Boolean doInBackground(Void... voids)
	{
		HttpClient httpClient = new DefaultHttpClient();
		HttpContext httpContext = new BasicHttpContext();
		HttpPost httpPost = new HttpPost(urlString);

		try
		{
			if (files != null && files.size() > 0)
			{
				//Initialize multipart entity.
				StellarMultipartEntity multipartContent = new StellarMultipartEntity(new ProgressListener()
				{
					@Override
					public void transferred(long num)
					{
						publishProgress((int) ((num / (float) totalSize) * PROGRESS_MAX));
					}
				});
				
				//Add file parts.
				addFileParts(multipartContent);
				
				//Add string parts.
				if (postDataValuesAndKeys != null)
				{
					for (NameValuePair pair : postDataValuesAndKeys)
					{
						if (isCancelled()) return null;
						multipartContent.addPart(pair.getName(), new StringBody(pair.getValue()));
					}
				}
				
				if (isCancelled()) return null;
					
				httpPost.setEntity(multipartContent);
			}
			else if (postDataValuesAndKeys != null)
			{
			    httpPost.setEntity(new UrlEncodedFormEntity(postDataValuesAndKeys));
			    
			    //For now progress is currently only supported for multipart requests. 
			    publishProgress(PROGRESS_MAX);
			}
			
		    totalSize = httpPost.getEntity().getContentLength();

			if (isCancelled()) return null;

			response = httpClient.execute(httpPost, httpContext);
			String responseString = EntityUtils.toString(response.getEntity());
			
			return processResponseData(responseString);
		}
		catch (Exception e)
		{
			processingResult = e;
		}
		
		return Boolean.valueOf(false);
	}

	
	@Override
	protected void onProgressUpdate(Integer... progress)
	{
		if (progressDelegate != null)
		{
			progressDelegate.progress(this, progress[0], PROGRESS_MAX);
		}
	}

	
	@Override
	protected void onPostExecute(Boolean result)
	{
		if (delegate != null && !isCancelled())
		{
			if (result)
			{
				delegate.result(this, processingResult);
			}
			else if (processingResult instanceof ClientProtocolException)
			{
				ClientProtocolException e = (ClientProtocolException) processingResult;
				delegate.httpError(this, null, response.getStatusLine().getStatusCode(), e.getMessage());
			}
			else if (processingResult instanceof IOException)
			{
				delegate.connectionError(this, ((IOException) processingResult).getMessage());
			}
			else
			{
				delegate.generalError(this, null);
			}
		}
	}
	
	
	protected abstract boolean processResponseData(String responseData);
	
	
	// Getter and Setter Methods

	public void setDelegate(StellarRequestDelegate1 delegate)
	{
		this.delegate = delegate;
	}
	
	public void setProgressDelegate(StellarRequestProgressDelegate progressDelegate)
	{
		this.progressDelegate = progressDelegate;
	}
	
	public void setType(int type)
	{
		this.type = type;
	}
	
	public Object getProcessingResult()
	{
		return processingResult;
	}

	public int getId()
	{
		return id;
	}
	
	public int getType()
	{
		return type;
	}
}

