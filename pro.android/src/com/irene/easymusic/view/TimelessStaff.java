package com.irene.easymusic.view;

import android.content.Context;
import android.view.View;

public class TimelessStaff extends View{
	
	private Context mContext;
	private float mLineSpace;
	private int mTotalLines;
	private int mBaseLevel;
	private int mTopLevel;
	private StaffAdapter mAdapter;
	private boolean mDataSetChanged;
	
	
	public static class Pitch{
		public int level;
		public String name;
	}
	
	interface StaffAdapter{
		public int getCount();
		public Pitch getPitch(int position);
	}

	public TimelessStaff(Context context) {
		super(context);
		mContext = context;
	}
	
	public void setAdapter(StaffAdapter adapter){
		mAdapter = adapter;
	}
	
	public void notifyDataSetChanged(){
		mDataSetChanged = true;
		requestLayout();
	}
	
	@Override
	protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
		// TODO Auto-generated method stub
		super.onLayout(changed, left, top, right, bottom);
		if(mDataSetChanged){
			mDataSetChanged = false;
			computeLineInfo();
		}
	}
	
	private void computeLineInfo(){
		if(mAdapter != null && mAdapter.getCount() > 0){
			for(int i = 0; i < mAdapter.getCount(); i++){
				Pitch pitch = mAdapter.getPitch(i);
				if( pitch.level > mTopLevel){
					mTopLevel = pitch.level;
				}
				if(pitch.level < mBaseLevel){
					mBaseLevel = pitch.level;
				}
			}
			mLineSpace = getHeight() * 2 / (mTopLevel - mBaseLevel);
		}
	}

}
