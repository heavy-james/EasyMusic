package com.irene.easymusic.bean;

import java.util.List;

public class Song extends Section{

	private List<MusicParagraph> mMusicParagraphs;
	
	
	
	public List<MusicParagraph> getmMusicParagraphs() {
		return mMusicParagraphs;
	}



	public void setmMusicParagraphs(List<MusicParagraph> mMusicParagraphs) {
		this.mMusicParagraphs = mMusicParagraphs;
	}



	@Override
	public String getTypeName() {
		// TODO Auto-generated method stub
		return "Song";
	}
}
