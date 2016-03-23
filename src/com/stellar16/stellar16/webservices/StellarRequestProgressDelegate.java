package com.stellar16.stellar16.webservices;

public interface StellarRequestProgressDelegate
{
	public void progress(StellarRequest1 request, int progress, int max);
}
