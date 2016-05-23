package com.irene.easymusic.bean;

public class Cadence extends Node{

	private int mForce;
	private int mLength;
	
	public int getmForce() {
		return mForce;
	}

	public void setmForce(int mForce) {
		this.mForce = mForce;
	}

	public int getmLength() {
		return mLength;
	}

	public void setmLength(int mLength) {
		this.mLength = mLength;
	}

	@Override
	public String getTypeName() {
		// TODO Auto-generated method stub
		return "Cadence";
	}
	

}
