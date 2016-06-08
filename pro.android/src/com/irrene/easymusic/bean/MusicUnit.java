package com.irrene.easymusic.bean;

import java.util.ArrayList;
import java.util.List;

public class MusicUnit extends Section{

	//用于解决小节内多个和弦变换
	private List<Chord> mChords;
	//用于解决小节内多个节奏型变换
	private List<Pattern> mPatterns;
	//小节和弦
	private Chord mChord;
	//小节节奏型
	private Pattern mPattern;
	private Lyric mLyric;
	private Melody mMelody;
	

	private MusicUnit(Builder builder){
		this.mChord = builder.chord;
		this.mPattern = builder.pattern;
		this.mLyric = builder.lyric;
		this.mMelody = builder.melody;
	}
	
	public void setLyric(Lyric lyric) {
		this.mLyric = lyric;
	}

	public Lyric getLyric() {
		return mLyric;
	}
	
	public boolean hasMultiChords(){
		if(null == mChords || mChords.size() == 0){
			return false;
		}
		return true;
	}
	
	public List<Chord> getMultiChords() {
		List<Chord> temp = null;
		if(mChord != null){
			temp = new ArrayList<Chord>();
			temp.add(mChord);
			if(hasMultiChords()){
				temp.addAll(mChords);
			}
		}
		return temp;
	}

	public void addMultiChord(Chord chord) {
		if(mChords == null){
			mChords = new ArrayList<Chord>();
		}
		mChords.add(chord);
	}

	public boolean hasMultiPatterns(){
		if(null == mPatterns || mPatterns.size() == 0){
			return false;
		}
		return true;
	}
	
	public List<Pattern> getMultiPatterns() {
		List<Pattern> temp = new ArrayList<Pattern>();
		temp.add(mPattern);
		if(hasMultiPatterns()){
			temp.addAll(mPatterns);
		}
		return temp;
	}

	public void addMultiPattern(Pattern pattern) {
		if(mPatterns == null){
			mPatterns = new ArrayList<Pattern>();
		}
		mPatterns.add(pattern);
	}

	public Melody getMelody() {
		return mMelody;
	}

	public void setMelody(Melody mMelody) {
		this.mMelody = mMelody;
	}

	
	public int getLength() {
		int length = 0;
		if(hasMultiPatterns()){
			for(Pattern pattern : getMultiPatterns()){
				length += pattern.getLength();
			}
		}else{
			length = mPattern.getLength();
		}
		return length;
	};
	
	public int getChordLength(){
		int length = 0;
		List<Chord> chords = getMultiChords();
		if(chords != null){
			for(Chord chord :chords){
				length += chord.getLength();
			}
		}
		return length;
	}
	
	public int getMelodyLength(){
		int length = 0;
		if(mMelody != null){
			length = mMelody.getLength();
		}
		return length;
	}
	
	public int getLyricsLength(){
		int length = 0;
		if(mLyric != null){
			length = mLyric.getLength();
		}
		return length;
	}
	
	public int getPatternLength(){
		int length = 0;
		List<Pattern> patterns = getMultiPatterns();
		if(patterns != null){
			for(Pattern pattern : patterns){
				length += pattern.getLength();
			}
		}
		return length;
	}

	@Override
	public String getTypeName() {
		// TODO Auto-generated method stub
		return "MusicUnit";
	}
	
	public boolean isValide(){
		return getPatternLength() == getMelodyLength();
	}
	
	public static class Builder{
		private Pattern pattern;
		private Chord chord;
		private Melody melody;
		private Lyric lyric;
		
		public Builder(Pattern pattern){
			this.pattern = pattern;
		}
		
		public Builder Chord(Chord chord){
			this.chord = chord;
			return this;
		}
		
		public Builder Melody(Melody melody){
			this.melody = melody;
			return this;
		}
		
		public Builder Lyric(Lyric lyric){
			this.lyric = lyric;
			return this;
		}
		
		public MusicUnit build(){
			return new MusicUnit(this);
		}
	}
	
}
