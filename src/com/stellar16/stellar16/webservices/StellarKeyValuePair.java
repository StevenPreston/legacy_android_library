package com.stellar16.stellar16.webservices;

public class StellarKeyValuePair <K, V>
{
	private K key;
	private V value;
	
	
	public StellarKeyValuePair(K key, V value)
	{
		this.key = key;
		this.value = value;
	}
	
	
	//Getter and Setter Methods

	public K getKey()
	{
		return key;
	}

	public void setKey(K key)
	{
		this.key = key;
	}

	public V getValue()
	{
		return value;
	}

	public void setValue(V value)
	{
		this.value = value;
	}
}
