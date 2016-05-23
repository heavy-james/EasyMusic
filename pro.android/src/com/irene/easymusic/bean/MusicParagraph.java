package com.irene.easymusic.bean;

import java.util.List;

public class MusicParagraph extends Section{
	private int mKey;
	private int mPartTag;
	private List<MusicSentence> mSententces;
	
	
	
	public int getmKey() {
		return mKey;
	}



	public void setmKey(int mKey) {
		this.mKey = mKey;
	}



	public int getmPartTag() {
		return mPartTag;
	}



	public void setmPartTag(int mPartTag) {
		this.mPartTag = mPartTag;
	}



	public List<MusicSentence> getmSententces() {
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
