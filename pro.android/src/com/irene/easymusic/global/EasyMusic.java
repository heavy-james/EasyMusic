package com.irene.easymusic.global;

import java.io.File;

import com.irene.easymusic.global.debug.CrashHandler;
import com.irene.easymusic.global.debug.LogUtil;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;

@SuppressLint("NewApi")
public class EasyMusic extends Application
{

	static {
		System.loadLibrary("DevWiki");
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
	}

	@Override
	public void onCreate() {
		super.onCreate();
		LogUtil.init(this, LogUtil.LEVEL_DEBUG, true, true, getExternalCacheDir().getAbsolutePath() + File.separator + "android_dev_wiki.log");
		GlobalActionManager.getInstance().init(this);
		//GlobalActionManager.getInstance().initNativeCrashHandler();
		Thread.setDefaultUncaughtExceptionHandler(CrashHandler.getInstance(this));
	}

	@Override
	public void onLowMemory() {
		// TODO Auto-generated method stub
		super.onLowMemory();
	}

	@Override
	public void onTerminate() {
		// TODO Auto-generated method stub
		super.onTerminate();
	}

	@Override
	public void onTrimMemory(int level) {
		// TODO Auto-generated method stub
		super.onTrimMemory(level);
	}

	@Override
	public void registerActivityLifecycleCallbacks(
			ActivityLifecycleCallbacks callback) {
		// TODO Auto-generated method stub
		super.registerActivityLifecycleCallbacks(callback);
	}

	@Override
	public void registerComponentCallbacks(ComponentCallbacks callback) {
		// TODO Auto-generated method stub
		super.registerComponentCallbacks(callback);
	}

	@Override
	public void registerOnProvideAssistDataListener(
			OnProvideAssistDataListener callback) {
		// TODO Auto-generated method stub
		super.registerOnProvideAssistDataListener(callback);
	}

	@Override
	public void unregisterActivityLifecycleCallbacks(
			ActivityLifecycleCallbacks callback) {
		// TODO Auto-generated method stub
		super.unregisterActivityLifecycleCallbacks(callback);
	}

	@Override
	public void unregisterComponentCallbacks(ComponentCallbacks callback) {
		// TODO Auto-generated method stub
		super.unregisterComponentCallbacks(callback);
	}

	@Override
	public void unregisterOnProvideAssistDataListener(
			OnProvideAssistDataListener callback) {
		// TODO Auto-generated method stub
		super.unregisterOnProvideAssistDataListener(callback);
	}
    
}
