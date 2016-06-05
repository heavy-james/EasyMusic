package com.irene.easymusic.bean;

import java.util.LinkedList;
import java.util.List;

public class Lyric extends Section{
	public static final String TAG = "Lyric";
	private List<Word> mWords;
	
	public Lyric(){
		mWords = new LinkedList<Word>();
	}
	
	public void addWord(Word word){
		mWords.add(word);
	}
}
