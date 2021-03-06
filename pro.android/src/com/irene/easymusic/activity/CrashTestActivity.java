package com.irene.easymusic.activity;


import com.irene.easymusic.R;
import com.irene.easymusic.global.BaseActivity;
import com.irene.easymusic.global.debug.LogUtil;

import android.os.Bundle;

public class CrashTestActivity extends BaseActivity{
	private static final String TAG = "CrashTestActivity";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_crashtest);
		LogUtil.d("CrashTestActivity", "oncreate");
		monitorNativeCrash();
	}
	
	@Override
	protected String getTag() {
		// TODO Auto-generated method stub
		return TAG;
	}
	
	native void monitorNativeCrash();
	
}
