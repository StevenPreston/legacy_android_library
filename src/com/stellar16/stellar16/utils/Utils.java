package com.stellar16.stellar16.utils;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;

public class Utils
{
	public static String componentsJoinedByString(ArrayList<Object> array, String string)
	{
		StringBuilder stringBuilder = new StringBuilder();
		
		int count = 0;
		for (Object component : array)
		{
			stringBuilder.append(component);
			
			if (count != array.size() - 1)
			{
				stringBuilder.append(string);
			}
			count++;
		}
		return stringBuilder.toString();
	}
	
	public static boolean isNotEmpty(CharSequence string)
	{
		return string != null && string.length() > 0;
	}
	
	
	public static int dpToPx(int dp, Context context)
	{
	    float density = context.getResources().getDisplayMetrics().density;
	    return Math.round((float)dp * density);
	}
	
	
	public static Builder getAlertDialog(Context context, String title, String message, int positiveButtonTextId, OnClickListener positiveOnClickListener)
	{
    	AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
    	alertDialog.setIcon(0);
    	
    	if (title != null)
    	{
    		alertDialog.setTitle(title);
    	}
    	
    	alertDialog.setMessage(message);
    	
    	if (positiveButtonTextId != 0)
    	{
    		alertDialog.setPositiveButton(positiveButtonTextId, positiveOnClickListener);
    	}
    	
    	return alertDialog;
	}
}
