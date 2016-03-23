package com.stellar16.stellar16.base;

import java.util.ArrayList;
import java.util.HashMap;


public class NotificationController
{
	public static String NOTIFICATION_RESULT = "NOTIFICATION_RESULT";
	
	private static NotificationController instance = null;
	private HashMap<String, ArrayList<NotificationObserver>> observers;
	
	protected NotificationController()
	{
		
	}

	
	public static NotificationController getInstance()
	{
		if (instance == null)
		{
			instance = new NotificationController();
		}
		return instance;
	}

	
	public void registerForNotifications(NotificationObserver observer, String name)
	{
		if (observers == null)
		{
			observers = new HashMap<String, ArrayList<NotificationObserver>>();
		}
		
		ArrayList<NotificationObserver> observerList = observers.get(name);
		if (observerList == null)
		{
			observerList = new ArrayList<NotificationObserver>();
			observers.put(name, observerList);
		}
		
		if (!observerList.contains(observer))
		{
			observerList.add(observer);
		}
	}


	public void deregisterForNotifications(NotificationObserver observer)
	{
		if (observers != null)
		{
			for (ArrayList<NotificationObserver> observerList : observers.values())
			{
				observerList.remove(observer);
			}
		}
	}
	
	
	public void postNotification(String name, Object object, HashMap<String, Object>userInfo)
	{
		if (observers == null)
		{
			return;
		}
		
		ArrayList<NotificationObserver> observerList = observers.get(name);
		if (observerList != null)
		{
			for (int i = 0; i < observerList.size(); i++)
			{
				NotificationObserver observer = observerList.get(i);
				
				Notification notification = new Notification(name, object, userInfo);
				observer.notificationReceived(notification);
			}
		}
	}
}
