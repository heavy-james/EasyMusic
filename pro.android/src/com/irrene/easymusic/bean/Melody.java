package com.irrene.easymusic.bean;

import java.util.LinkedList;
import java.util.List;

public class Melody extends Section{
	private List<Sound> mSounds;
	private int mLength = 0;
	
	
	public Melody(){
		mSounds = new LinkedList<Sound>();
	}

	public List<Sound> getSounds() {
		return mSounds;
	}

	public void addSound(Sound sound){
		mSounds.add(sound);
		mLength += sound.getLength();
	}
	
	@Override
	public int getLength() {
		return mLength;
	}
}
