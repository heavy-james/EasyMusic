package com.irrene.easymusic.test;

import java.util.LinkedList;
import java.util.Queue;

import com.irrene.easymusic.test.bean.TestCase;

import android.content.Context;

public class TestManager {
	
	private  static TestManager mInstance;
	private static Context mContext;
	private volatile Queue<TestCase> mTestCaseQueue;
	private Object mLock;
	private boolean mStopFlag = false;
	private Runnable mTestRunnable = new Runnable() {
		public void run() {
			while(!mStopFlag){
				synchronized(mLock){
					TestCase testCase = mTestCaseQueue.poll();
					if(testCase != null){
						testCase.run();
					}else{
						try {
							mLock.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}
	};
	
	
	private TestManager(Context context){
		mContext = context;
		mTestCaseQueue = new LinkedList<TestCase>();
		mLock = new Object();
	}

	public static synchronized TestManager getInstance(Context context){
		if(null == mInstance){
			mInstance = new TestManager(mContext);
		}
		return mInstance;
	}
	
	public void addCase(TestCase testCase){
		synchronized(mLock){
			mTestCaseQueue.add(testCase);
			mLock.notify();
		}
	}
	
	public void run(){
		mStopFlag = false;
		new Thread(mTestRunnable).start();
	}
	
	public void stop(){
		mStopFlag = true;
	}
	
	public void clear(){
		mStopFlag = true;
		mTestCaseQueue.clear();
		mInstance = null;
	}
}
