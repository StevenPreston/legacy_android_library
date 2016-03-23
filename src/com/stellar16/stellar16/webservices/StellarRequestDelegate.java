package com.stellar16.stellar16.webservices;

public interface StellarRequestDelegate
{
	public void result(StellarRequest request, Object result);
	public void connectionError(StellarRequest request, Object result);
	public void generalError(StellarRequest request, Object result);
	public void httpError(StellarRequest request, Object result, int errorCode, String errorMessage);
}
