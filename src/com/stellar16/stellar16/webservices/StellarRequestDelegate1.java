package com.stellar16.stellar16.webservices;

public interface StellarRequestDelegate1
{
	public void result(StellarRequest1 request, Object result);
	public void connectionError(StellarRequest1 request, Object result);
	public void generalError(StellarRequest1 request, Object result);
	public void httpError(StellarRequest1 request, Object result, int errorCode, String errorMessage);
}
