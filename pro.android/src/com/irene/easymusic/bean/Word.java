package com.irene.easymusic.bean;

public class Word extends Sound{
	
	public static final String TAG = "Word";
	private String mValue = "";

	
	private Word(Builder builder){
		super(builder.name,builder.cadence);
		mValue = builder.value;
	}
	
	public String getValue(){
		return mValue;
	}
	
	public static class Builder{
		private String value;
		private int name;
		private Cadence cadence;
		public Builder(String value){
			this.value = value;
		}
		
		public Builder name(int name){
			this.name = name;
			return this;
		}
		
		public Builder cadence(Cadence cadence){
			this.cadence = cadence;
			return this;
		}
		
		public Builder sound(Sound sound){
			this.name = sound.getName();
			this.cadence = sound.getCadence();
			return this;
		}
		
		public Word build(){
			return new Word(this);
		}
	}

}
