package com.stellar16.stellar16.base;

import java.util.HashMap;

public class Notification
{
	private String name;
	private Object object;
	private HashMap<String, Object> userInfo;
	
	
	public Notification(String name, Object object, HashMap<String, Object> userInfo)
	{
		this.name = name;
		this.object = object;
		this.userInfo = userInfo;
	}
	
	
	//Getter Methods
	
	public String getName()
	{
		return name;
	}
	
	
	public Object getObject()
	{
		return object;
	}
	
	
	public HashMap<String, Object> getUserInfo()
	{
		return userInfo;
	}
}
