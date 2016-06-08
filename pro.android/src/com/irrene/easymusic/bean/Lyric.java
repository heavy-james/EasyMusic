package com.irrene.easymusic.bean;

import java.util.LinkedList;
import java.util.List;

public class Lyric extends Section{
	public static final String TAG = "Lyric";
	private List<Word> mWords;
	private int mLength = 0;
	
	public Lyric(){
		mWords = new LinkedList<Word>();
	}
	
	public void addWord(Word word){
		mWords.add(word);
		mLength += word.getLength();
	}
	
	public int getLength(){
		return mLength;
	}
}
