package com.irene.easymusic.activity;

import com.irene.easymusic.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PitchPosTraingActivity extends Activity{
	
	private Button mStaffSelectionButton;
	private ImageView mContentPicView;
	private TextView mContentDescriptionView;
	private Context mContext;
	private TrainingAdapter mAdapter;
	private int mStaffType;
	
	public static class Pitch{
		public int level;
		public String name;
	}
	
	interface TrainingAdapter{
		public Pitch getPrePitch();
		public Pitch getNextPitch();
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_pitch_pos_training_activity);
	}
	
	private void initData(Context context){
		mContext = context;
		mAdapter = new MyTrainingAdapter();
	}
	
	private void initView(){
		mStaffSelectionButton = (Button)findViewById(R.id.staffButton);
		mContentDescriptionView = (TextView)findViewById(R.id.contentDiscription);
		mContentPicView = (ImageView)findViewById(R.id.contentPicture);
		mContentPicView.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				if(event.getAction() == MotionEvent.ACTION_UP){
					v.performClick();
				}
				return processTouchEvent(v, event);
			}
		});
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		
		return processTouchEvent(null , event) || super.onTouchEvent(event);
	}
	
	private boolean processTouchEvent(View view, MotionEvent event){
		if(view != null && view.getId() == R.id.contentPicture){
			float distanceX = 0;
			if(event.getAction() == MotionEvent.ACTION_DOWN){
				distanceX = event.getX();
			}else if(event.getAction() == MotionEvent.ACTION_UP){
				distanceX = event.getX() - distanceX;
				if(distanceX > 50){
					
				}
			}
		}else{
			float distanceY = 0;
			if(event.getAction() == MotionEvent.ACTION_DOWN){
				distanceY = event.getY();
			}else if(event.getAction() == MotionEvent.ACTION_UP){
				distanceY = event.getY() - distanceY;
				if(distanceY > 50){
					
				}
			}
		}
		return false;
	}
	
	private class MyTrainingAdapter implements TrainingAdapter{

		private Pitch sPrePitch;
		private Pitch sNextPitch;
		@Override
		public Pitch getPrePitch() {
			// TODO Auto-generated method stub
			Pitch res;
			if(sPrePitch != null){
				res = sPrePitch;
				sPrePitch = null;
			}else{
				res = newPitch();
			}
			sNextPitch = res;
			return res;
		}
		
		@Override
		public Pitch getNextPitch() {
			Pitch res;
			if(sNextPitch != null){
				res = sNextPitch;
				sNextPitch = null;
			}else{
				res = new Pitch();
			}
			sPrePitch = res;
			return res;
		}
		
		private Pitch newPitch(){
			Pitch temp = new Pitch();
			temp.level = (int)(Math.random() * 23 );
			switch(mStaffType){
			case 0:
				break;
			case 1:
				temp.level += 22;
				break;
			default:
				break;				
			}
			return temp;
		}
		
	}
	
}
