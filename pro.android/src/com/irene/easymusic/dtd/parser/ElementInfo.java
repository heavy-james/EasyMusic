package com.irene.easymusic.dtd.parser;


public class ElementInfo {
	
	
	public ElementInfo(String name,int existenceFlag){
		mName = name;
		mExistenceFlag = existenceFlag;
	}
	
	private String mName;
	private int mExistenceFlag = 0;
	
	public String getName(){
		return mName;
	}
	
	public int getExistenceFlag(){
		return mExistenceFlag;
	}
}
