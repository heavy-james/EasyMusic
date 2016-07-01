package com.irene.easymusic.bean;

import java.util.ArrayList;
import java.util.List;

public class Song extends Section {

	private Key mKey;
	private String mName;
	private Pattern mPattern;
	private boolean mMultiPart = false;
	private boolean mMultiRhythm = false;
	private boolean mMultiKey = false;
	private int mSpeed = 0;
	private List<MusicParagraph> mMusicParagraphs;
	
	
	
	public Song(String name,Key key,Pattern pattern,int Speed){
		mMusicParagraphs = new ArrayList<MusicParagraph>();
	}
	
	public void addParagraph(MusicParagraph paragraph){
		mMusicParagraphs.add(paragraph);
	}

	public List<MusicParagraph> getmMusicParagraphs() {
		return mMusicParagraphs;
	}

	@Override
	public String getTypeName() {
		// TODO Auto-generated method stub
		return "Song";
	}
}
