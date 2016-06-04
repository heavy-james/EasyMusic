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
		int distance = 0;
		Sound tempSound;
		Chord tempChord;
		switch(mKeyAttri){
		case Attribute.DIATONIC_MAJOR:
			for(int i = 1; i < 8; i++){
				if(i == 1){
					distance = 0;
				}else if(i == 4){
					distance += 1;
				}else{
					distance += 2;
				}
				tempSound = new Sound(mBase.getName() + distance, null);
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
			return true;
		case Attribute.DIATONIC_MINOR:
			for(int i = 1; i < 8; i++){
				
				if(i == 1){
					distance = 0;
				}else if(i == 3 || i == 6){
					distance += 1;
				}else{
					distance += 2;
				}
				tempSound = new Sound(mBase.getName() + distance, null);
				if(i == 1 || i == 4 || i == 5){
					tempChord = new Chord.Builder(tempSound, Chord.Attribute.Three.ATTRI_MINOR_3).build();
				}else if(i == 2){
					tempChord = new Chord.Builder(tempSound, Chord.Attribute.Three.ATTRI_DIMINISHED_3).build();
				}else {
					tempChord = new Chord.Builder(tempSound, Chord.Attribute.Three.ATTRI_MAJOR_3).build();
				}
				mSoundevels.add(tempSound);
				mChordLevels.add(tempChord);
			}
			return true;
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
	
	
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("调式名称-->" + mBase.getSoundName());
		builder.append("调式属性-->" + Attribute.getAttriName(mKeyAttri) + "\n");
		for(int i = 0; i < mSoundevels.size(); i++){
			Sound sound = mSoundevels.get(i);
			builder.append("第" + (i + 1) + "级音阶-->");
			builder.append(sound.toString());
		}
		for(int i = 0; i < mSoundevels.size(); i++){
			Chord chord = mChordLevels.get(i);
			builder.append("第" + (i + 1) + "级和弦-->");
			builder.append(chord.toString());
		}
		return builder.toString();
	}
	
	public static class Builder{
		private Sound base;
		private int attri;
		
		public Builder(Sound base, int attri){
			this.base = base;
			this.attri = attri;
		}
		
		public Key build(){
			Key res = new Key(this);
			if(res.init()){
				return res;
			}
			return null;
		}
	}
	
	public static class Attribute{
		
		public static String getAttriName(int attri){
			String name = "";
			switch(attri){
			case DIATONIC_MAJOR:
				name = "自然大调";
				break;
			case DIATONIC_MINOR:
				name = "自然小调";
				break;
			case HARMONIC_MAJOR:
				name = "和声大调";
				break;
			case HARMONIC_MINOR:
				name = "和声小调";
				break;
			case MELODIC_MAJOR:
				name = "旋律大调";
				break;
			case MELODIC_MINOR:
				name = "旋律小调";
				break;
			}
			return name;
		}
		public static final int DIATONIC_MAJOR = 1;
		public static final int DIATONIC_MINOR = 2;
		public static final int MELODIC_MAJOR = 3;
		public static final int MELODIC_MINOR = 4;
		public static final int HARMONIC_MAJOR = 5;
		public static final int HARMONIC_MINOR = 6;
	}
}
