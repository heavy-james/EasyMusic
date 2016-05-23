package com.irene.easymusic.bean;

import java.util.List;

public class MusicUnit extends Section{

	private List<Chord> mChords;
	private List<Pattern> mPatterns;
	private Melody mMelody;
	
	
	public List<Chord> getmChords() {
		return mChords;
	}


	public void setmChords(List<Chord> mChords) {
		this.mChords = mChords;
	}


	public List<Pattern> getmPatterns() {
		return mPatterns;
	}


	public void setmPatterns(List<Pattern> mPatterns) {
		this.mPatterns = mPatterns;
	}


	public Melody getmMelody() {
		return mMelody;
	}


	public void setmMelody(Melody mMelody) {
		this.mMelody = mMelody;
	}


	@Override
	public String getTypeName() {
		// TODO Auto-generated method stub
		return "MusicUnit";
	}
	
}
