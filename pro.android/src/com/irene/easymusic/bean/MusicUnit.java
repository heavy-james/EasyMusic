package com.irene.easymusic.bean;

import java.util.List;

public class MusicUnit extends Section{

	private List<Chord> mChords;
	private List<Pattern> mPatterns;
	private Melody mMelody;
	
	
	public List<Chord> getChords() {
		return mChords;
	}


	public void setChords(List<Chord> mChords) {
		this.mChords = mChords;
	}


	public List<Pattern> getPatterns() {
		return mPatterns;
	}


	public void setPatterns(List<Pattern> mPatterns) {
		this.mPatterns = mPatterns;
	}


	public Melody getMelody() {
		return mMelody;
	}


	public void setMelody(Melody mMelody) {
		this.mMelody = mMelody;
	}


	@Override
	public String getTypeName() {
		// TODO Auto-generated method stub
		return "MusicUnit";
	}
	
}
