package com.irene.easymusic.bean;

import java.util.ArrayList;
import java.util.List;

public class Key {
	private Sound mBase;
	private int mKeyAttri;
	private List<Sound> mSoundevels;
	private List<Chord> mChordLevels;
	
	private Key(Builder builder){
		mBase = builder.base;
		mKeyAttri = builder.attri;
		mSoundevels = new ArrayList<Sound>();
		mChordLevels = new ArrayList<Chord>();
	}
	
	public int getKeyValue() {
		return mBase.getName();
	}

	public String getKeyName() {
		return mBase.getSoundName();
	}

	public int getKeyAttri() {
		return mKeyAttri;
	}

	public List<Sound> getKeyLevels() {
		return mSoundevels;
	}

	public List<Chord> getChordLevels() {
		return mChordLevels;
	}

	private boolean init(){
		switch(mKeyAttri){
		case Attribute.DIATONIC_MAJOR:
			for(int i = 1; i < 8; i++){
				Sound tempSound;
				Chord tempChord;
				if(i == 3){
					tempSound = new Sound(mBase.getName() + 1, null);
				}else{
					tempSound = new Sound(mBase.getName() + 2, null);
				}
				
				if(i == 1 || i == 4 || i == 5){
					tempChord = new Chord.Builder(tempSound, Chord.Attribute.Three.ATTRI_MAJOR_3).build();
				}else if(i == 7){
					tempChord = new Chord.Builder(tempSound, Chord.Attribute.Three.ATTRI_DIMINISHED_3).build();
				}else {
					tempChord = new Chord.Builder(tempSound, Chord.Attribute.Three.ATTRI_MINOR_3).build();
				}
				mSoundevels.add(tempSound);
				mChordLevels.add(tempChord);
			}
			break;
		case Attribute.DIATONIC_MINOR:
			for(int i = 0; i < 7; i++){
				if(i == 1 || i == 4){
					mSoundevels.add(new Sound(mBase.getName() + 1, null));
				}else{
					mSoundevels.add(new Sound(mBase.getName() + 2, null));
				}
			}
			break;
		case Attribute.HARMONIC_MAJOR:
			break;
		case Attribute.HARMONIC_MINOR:
			break;
		case Attribute.MELODIC_MAJOR:
			break;
		case Attribute.MELODIC_MINOR:
			break;
		}
		return false;
	}
	
	
	public static class Builder{
		private Sound base;
		private int attri;
		
		public Builder(Sound base, int attri){
			
		}
		
		public Key build(){
			return null;
		}
	}
	
	public static class Attribute{
		public static final int DIATONIC_MAJOR = 1;
		public static final int DIATONIC_MINOR = 2;
		public static final int MELODIC_MAJOR = 3;
		public static final int MELODIC_MINOR = 4;
		public static final int HARMONIC_MAJOR = 5;
		public static final int HARMONIC_MINOR = 6;
	}
}
