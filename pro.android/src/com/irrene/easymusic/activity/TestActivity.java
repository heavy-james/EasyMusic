package com.irrene.easymusic.activity;

import com.irrene.easymusic.test.TestManager;
import com.irrene.easymusic.test.bean.ChordTest;
import com.irrene.easymusic.test.bean.KeyTest;
import com.irrene.easymusic.test.bean.NumberNotationTest;

import android.app.Activity;
import android.os.Bundle;

public class TestActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		TestManager.getInstance(this.getApplicationContext()).addCase(new NumberNotationTest());
	}
	
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		TestManager.getInstance(getApplicationContext()).run();
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		TestManager.getInstance(getApplicationContext()).stop();
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		TestManager.getInstance(getApplicationContext()).clear();
	}

}
