package com.stellar16.stellar16.utils;

import android.animation.LayoutTransition;
import android.annotation.TargetApi;
import android.os.Build;
import android.view.ViewGroup;

public class AnimationUtils
{
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public static void enableAnimationTransition(Object view)
	{
		if (view instanceof ViewGroup && Build.VERSION.SDK_INT > 10)
		{
			LayoutTransition transition = new LayoutTransition();
			transition.setAnimator(LayoutTransition.CHANGE_APPEARING, null);
			transition.setAnimator(LayoutTransition.CHANGE_DISAPPEARING, null);
			ViewGroup viewGroup = (ViewGroup) view;
			viewGroup.setLayoutTransition(transition);
		}
	}
	
	
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public static void disableAnimationTransition(Object view)
	{
		if (view instanceof ViewGroup && Build.VERSION.SDK_INT > 10)
		{
			ViewGroup viewGroup = (ViewGroup) view;
			viewGroup.setLayoutTransition(null);
		}
	}
}
