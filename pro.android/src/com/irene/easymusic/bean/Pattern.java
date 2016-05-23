package com.irene.easymusic.bean;

import java.util.List;

public class Pattern extends Section {
	List<Cadence> mCandences;
	
	@Override
	public String getTypeName() {
		// TODO Auto-generated method stub
		return "Pattern";
	}

	public List<Cadence> getmCandences() {
		return mCandences;
	}

	public void setmCandences(List<Cadence> mCandences) {
		this.mCandences = mCandences;
	}
}
