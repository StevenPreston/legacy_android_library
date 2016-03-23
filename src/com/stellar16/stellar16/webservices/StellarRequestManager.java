package com.stellar16.stellar16.webservices;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import android.util.SparseArray;

import com.loopj.android.http.AsyncHttpClient;

public class StellarRequestManager
{
	private static StellarRequestManager instance = null;
	private AsyncHttpClient client;
	private SparseArray<SparseArray<StellarRequestContext>> contexts;
	
	
	protected StellarRequestManager()
	{
		contexts = new SparseArray<SparseArray<StellarRequestContext>>();
		client = new AsyncHttpClient();
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
		client.setThreadPool(executor);
		client.setTimeout(30000);
	}

	
	public static StellarRequestManager getInstance()
	{
		if (instance == null)
		{
			instance = new StellarRequestManager();
		}
		return instance;
	}
	
	
	public StellarRequestContext getContext(int id, int type)
	{
		SparseArray<StellarRequestContext> contextArray = contexts.get(id);
		if (contextArray == null)
		{
			contextArray = new SparseArray<StellarRequestContext>();
			contexts.put(id, contextArray);
		}
		
		StellarRequestContext context = contextArray.get(id);
		if (context == null)
		{
			 context = new StellarRequestContext(id);
			 contextArray.put(type, context);
		}
		
		return context;
	}
	
	
	public AsyncHttpClient getClient()
	{
		return client;
	}
	
	
	public void cancelRequests(int id)
	{
		SparseArray<StellarRequestContext> contextArray = contexts.get(id);
		if (contextArray != null)
		{
			int key;
			for (int i = 0; i < contextArray.size(); i++)
			{
				key = contextArray.keyAt(i);
				StellarRequestContext context = contextArray.get(key);
				
				if (context != null)
				{
					client.cancelRequests(context, true);
				}
			}
		}
	}
	
	
	public void cancelRequests(int id, int type)
	{
		SparseArray<StellarRequestContext> contextArray = contexts.get(id);
		if (contextArray != null)
		{
			StellarRequestContext context = contextArray.get(type);
			if (context != null)
			{
				client.cancelRequests(context, true);
			}
		}
	}
}
