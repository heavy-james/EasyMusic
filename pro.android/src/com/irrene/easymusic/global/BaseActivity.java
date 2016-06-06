package com.irrene.easymusic.global;

import com.irrene.easymusic.global.GlobalActionManager.GlobalActionListener;
import com.irrene.easymusic.global.debug.LogUtil;

import android.app.Activity;
import android.os.Bundle;

public abstract class BaseActivity extends Activity {

	private GlobalActionListener mGlobalActionListener;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mGlobalActionListener = new BaseActionListener();
		GlobalActionManager.getInstance().addListener(getTag(), mGlobalActionListener);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (mGlobalActionListener != null) {
			GlobalActionManager.getInstance().removeListener(getTag());
		}
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}

	protected abstract String getTag();

	class BaseActionListener implements GlobalActionListener {

		@Override
		public void onFinishActivty() {
			LogUtil.d(getTag(), "onFinishActivty");
			finish();
		}

		@Override
		public void onTernimateApp() {
			LogUtil.d(getTag(), "onTernimateApp");
			finish();
		}
	}

}
