package com.irene.easymusic.bean;

import java.util.List;

public class MusicParagraph extends Section{
	
	public static final String PROP_NAME_PART = "part";
	
	private int mKey;
	private int mPartTag;
	private List<MusicSentence> mSententces;
	
	
	
	public int getKey() {
		return mKey;
	}



	public void setKey(int mKey) {
		this.mKey = mKey;
	}



	public int getPartTag() {
		return mPartTag;
	}



	public void setPartTag(int mPartTag) {
		this.mPartTag = mPartTag;
	}



	public List<MusicSentence> getSententces() {
		return mSententces;
	}



	public void setmSententces(List<MusicSentence> mSententces) {
		this.mSententces = mSententces;
	}



	@Override
	public String getTypeName() {
		// TODO Auto-generated method stub
		return "MusicParagraph";
	}
}
