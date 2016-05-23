package com.irene.easymusic.bean;

public class Sound extends Node{
	
	private int mName;
	private Cadence mCadence;
	
	

	public int getmName() {
		return mName;
	}



	public void setmName(int mName) {
		this.mName = mName;
	}



	public Cadence getmCadence() {
		return mCadence;
	}



	public void setmCadence(Cadence mCadence) {
		this.mCadence = mCadence;
	}



	@Override
	public String getTypeName() {
		// TODO Auto-generated method stub
		return "Sound";
	}
	
}
