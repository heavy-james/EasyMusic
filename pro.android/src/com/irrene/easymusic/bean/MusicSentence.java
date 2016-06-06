package com.irrene.easymusic.bean;

import java.util.List;

public class MusicSentence extends Section{
	
	private List<MusicUnit> mUnits;
	
	@Override
	public String getTypeName() {
		// TODO Auto-generated method stub
		return "MusicSentence";
	}

	public List<MusicUnit> getmUnits() {
		return mUnits;
	}

	public void setmUnits(List<MusicUnit> mUnits) {
		this.mUnits = mUnits;
	}
	
}
