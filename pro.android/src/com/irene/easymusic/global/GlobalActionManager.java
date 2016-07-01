package com.irene.easymusic.global;

import java.util.HashMap;
import java.util.Map;

import com.irene.easymusic.global.debug.LogUtil;

import android.content.Context;

public class GlobalActionManager{

	private static final String TAG = "GlobalActionManager";
	public static final String ACTION_FINISHA_CTIVITY = "finish_activity";
	public static final String ACTION_TERMINATE_APP = "terminate_app";
	private static GlobalActionManager mInstance;
	private Map<String, GlobalActionListener> mListenerMap;
	private boolean mInited = false;
	
	public static synchronized GlobalActionManager getInstance(){
		if(mInstance == null){
			mInstance = new GlobalActionManager();
		}
		return mInstance;
	}
	
	private GlobalActionManager(){
	}
	
	public void init(Context context){
		mListenerMap = new HashMap<String, GlobalActionManager.GlobalActionListener>();
		mInited = true;
		LogUtil.d(TAG, "GlobalActionManager init");
	}
	
	public void release(){
		mInstance = null;
	}
	
	public interface GlobalActionListener{
		void onFinishActivty();
		void onTernimateApp();
	}
	
	public boolean addListener(String action,GlobalActionListener listener){
		if(action != null && listener != null && mInited && mListenerMap.get(action) == null){
			mListenerMap.put(action, listener);
			LogUtil.d(TAG, "GlobalActionManager addListener action-->" + action);
			return true;
		}
		return false;
	}
	
	public void removeListener(String action){
		if(action != null){
			mListenerMap.remove(action);
		}
	}
	
	
	public void sendGlobalAction(String action,String targetName){
		LogUtil.d(TAG, "GlobalActionManager sendGlobalAction action-->" + action);
		if(ACTION_FINISHA_CTIVITY.equals(action)){
			if(mListenerMap.get(targetName) != null){
				LogUtil.d(TAG, "GlobalActionManager call lisnter -->" + mListenerMap.get(targetName));
				mListenerMap.get(targetName).onFinishActivty();
			}
		}else if(ACTION_TERMINATE_APP.equals(action)){
			for(Map.Entry<String, GlobalActionListener> entry : mListenerMap.entrySet()){
				LogUtil.d(TAG, "GlobalActionManager call lisnter -->" + entry.getValue());
				entry.getValue().onTernimateApp();
			}
		}
	}
	
	native void initNativeCrashHandler();

}
