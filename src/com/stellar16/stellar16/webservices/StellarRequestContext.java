package com.stellar16.stellar16.webservices;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.view.Display;

public class StellarRequestContext extends Context
{
	private int id;
	
	public StellarRequestContext(int id)
	{
		this.id = id;
	}
	
	public int getId()
	{
		return id;
	}

	@Override
	public boolean bindService(Intent service, ServiceConnection conn, int flags)
	{
		return false;
	}

	@Override
	public int checkCallingOrSelfPermission(String permission)
	{
		return 0;
	}

	@Override
	public int checkCallingOrSelfUriPermission(Uri uri, int modeFlags)
	{
		return 0;
	}

	@Override
	public int checkCallingPermission(String permission)
	{
		return 0;
	}

	@Override
	public int checkCallingUriPermission(Uri uri, int modeFlags)
	{
		return 0;
	}

	@Override
	public int checkPermission(String permission, int pid, int uid)
	{
		return 0;
	}


	@Override
	public int checkUriPermission(Uri uri, int pid, int uid, int modeFlags)
	{
		return 0;
	}

	@Override
	public int checkUriPermission(Uri uri, String readPermission, String writePermission, int pid, int uid, int modeFlags)
	{
		return 0;
	}

	@Override
	@Deprecated
	public void clearWallpaper() throws IOException
	{
	}

	@Override
	public Context createPackageContext(String packageName, int flags) throws NameNotFoundException
	{
		return null;
	}

	@Override
	public String[] databaseList()
	{
		return null;
	}

	@Override
	public boolean deleteDatabase(String name)
	{
		return false;
	}

	@Override
	public boolean deleteFile(String name)
	{
		return false;
	}

	@Override
	public void enforceCallingOrSelfPermission(String permission, String message)
	{
	}

	@Override
	public void enforceCallingOrSelfUriPermission(Uri uri, int modeFlags, String message)
	{
	}

	@Override
	public void enforceCallingPermission(String permission, String message)
	{
	}

	@Override
	public void enforceCallingUriPermission(Uri uri, int modeFlags, String message)
	{
	}

	@Override
	public void enforcePermission(String permission, int pid, int uid, String message)
	{
	}

	@Override
	public void enforceUriPermission(Uri uri, int pid, int uid, int modeFlags, String message)
	{
	}

	@Override
	public void enforceUriPermission(Uri uri, String readPermission, String writePermission, int pid, int uid, int modeFlags, String message)
	{
	}

	@Override
	public String[] fileList()
	{
		return null;
	}

	@Override
	public Context getApplicationContext()
	{
		return null;
	}

	@Override
	public ApplicationInfo getApplicationInfo()
	{
		return null;
	}

	@Override
	public AssetManager getAssets()
	{
		return null;
	}

	@Override
	public File getCacheDir()
	{
		return null;
	}

	@Override
	public ClassLoader getClassLoader()
	{
		return null;
	}

	@Override
	public ContentResolver getContentResolver()
	{
		return null;
	}

	@Override
	public File getDatabasePath(String name)
	{
		return null;
	}

	@Override
	public File getDir(String name, int mode)
	{
		return null;
	}

	@Override
	public File getExternalCacheDir()
	{
		return null;
	}

	@Override
	public File getExternalFilesDir(String type)
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public File getFileStreamPath(String name)
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public File getFilesDir()
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Looper getMainLooper()
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public File getObbDir()
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getPackageCodePath()
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public PackageManager getPackageManager()
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getPackageName()
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getPackageResourcePath()
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Resources getResources()
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public SharedPreferences getSharedPreferences(String name, int mode)
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Object getSystemService(String name)
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Theme getTheme()
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	@Deprecated
	public Drawable getWallpaper()
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	@Deprecated
	public int getWallpaperDesiredMinimumHeight()
	{
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	@Deprecated
	public int getWallpaperDesiredMinimumWidth()
	{
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void grantUriPermission(String toPackage, Uri uri, int modeFlags)
	{
		// TODO Auto-generated method stub
		
	}


	@Override
	public FileInputStream openFileInput(String name) throws FileNotFoundException
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public FileOutputStream openFileOutput(String name, int mode) throws FileNotFoundException
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public SQLiteDatabase openOrCreateDatabase(String name, int mode, CursorFactory factory)
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public SQLiteDatabase openOrCreateDatabase(String name, int mode, CursorFactory factory, DatabaseErrorHandler errorHandler)
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	@Deprecated
	public Drawable peekWallpaper()
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter)
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter, String broadcastPermission, Handler scheduler)
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void removeStickyBroadcast(Intent intent)
	{
		// TODO Auto-generated method stub
		
	}


	@Override
	public void revokeUriPermission(Uri uri, int modeFlags)
	{
		// TODO Auto-generated method stub
		
	}


	@Override
	public void sendBroadcast(Intent intent)
	{
		// TODO Auto-generated method stub
		
	}


	@Override
	public void sendBroadcast(Intent intent, String receiverPermission)
	{
		// TODO Auto-generated method stub
		
	}


	@Override
	public void sendOrderedBroadcast(Intent intent, String receiverPermission)
	{
		// TODO Auto-generated method stub
		
	}


	@Override
	public void sendOrderedBroadcast(Intent intent, String receiverPermission, BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData, Bundle initialExtras)
	{
		// TODO Auto-generated method stub
		
	}


	@Override
	public void sendStickyBroadcast(Intent intent)
	{
		// TODO Auto-generated method stub
		
	}


	@Override
	public void sendStickyOrderedBroadcast(Intent intent, BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData, Bundle initialExtras)
	{
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setTheme(int resid)
	{
		// TODO Auto-generated method stub
		
	}


	@Override
	@Deprecated
	public void setWallpaper(Bitmap bitmap) throws IOException
	{
		// TODO Auto-generated method stub
		
	}


	@Override
	@Deprecated
	public void setWallpaper(InputStream data) throws IOException
	{
		// TODO Auto-generated method stub
		
	}


	@Override
	public void startActivities(Intent[] intents)
	{
		// TODO Auto-generated method stub
		
	}


	@Override
	public void startActivities(Intent[] intents, Bundle options)
	{
		// TODO Auto-generated method stub
		
	}


	@Override
	public void startActivity(Intent intent)
	{
		// TODO Auto-generated method stub
		
	}


	@Override
	public void startActivity(Intent intent, Bundle options)
	{
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean startInstrumentation(ComponentName className, String profileFile, Bundle arguments)
	{
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void startIntentSender(IntentSender intent, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws SendIntentException
	{
		// TODO Auto-generated method stub
		
	}


	@Override
	public void startIntentSender(IntentSender intent, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws SendIntentException
	{
		// TODO Auto-generated method stub
		
	}


	@Override
	public ComponentName startService(Intent service)
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean stopService(Intent service)
	{
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void unbindService(ServiceConnection conn)
	{
		// TODO Auto-generated method stub
		
	}


	@Override
	public void unregisterReceiver(BroadcastReceiver receiver)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public Context createConfigurationContext(Configuration overrideConfiguration)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Context createDisplayContext(Display display)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeStickyBroadcastAsUser(Intent intent, UserHandle user)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendBroadcastAsUser(Intent intent, UserHandle user)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendBroadcastAsUser(Intent intent, UserHandle user, String receiverPermission)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendOrderedBroadcastAsUser(Intent intent, UserHandle user, String receiverPermission, BroadcastReceiver resultReceiver, Handler scheduler,
			int initialCode, String initialData, Bundle initialExtras)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendStickyBroadcastAsUser(Intent intent, UserHandle user)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendStickyOrderedBroadcastAsUser(Intent intent, UserHandle user, BroadcastReceiver resultReceiver, Handler scheduler, int initialCode,
			String initialData, Bundle initialExtras)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public File[] getExternalCacheDirs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public File[] getExternalFilesDirs(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public File[] getObbDirs() {
		// TODO Auto-generated method stub
		return null;
	}
}
