package com.irene.easymusic.bean;

import java.util.List;

public class Chord extends Section{
	private List<Sound> mSounds;
	private int mReverseTag;
	private int mChordType;
	
	@Override
	public String getTypeName() {
		// TODO Auto-generated method stub
		return "Chord";
	}

	public List<Sound> getmSounds() {
		return mSounds;
	}

	public void setmSounds(List<Sound> mSounds) {
		this.mSounds = mSounds;
	}

	public int getmReverseTag() {
		return mReverseTag;
	}

	public void setmReverseTag(int mReverseTag) {
		this.mReverseTag = mReverseTag;
	}

	public int getmChordType() {
		return mChordType;
	}

	public void setmChordType(int mChordType) {
		this.mChordType = mChordType;
	}

}
