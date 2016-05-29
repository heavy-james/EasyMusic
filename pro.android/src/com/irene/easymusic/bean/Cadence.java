package com.irene.easymusic.bean;

public class Cadence extends Node{
	
	public static class Force{
		public static final int FORCE_SUPER_WEAK = 0x000001;
		public static final int FORCE_WEAK = 0x000010;
		public static final int FORCE_SECOND_WEAK = 0x000100;
		public static final int FORCE_SECOND_STRONG = 0x001000;
		public static final int FORCE_STRONG = 0x010000;
		public static final int FORCE_SUPER_STRONG = 0x100000;
	}
	
	public static class Length{
		public static final int LENGTH_ONE_SIXTY_FOUR_BEAT = 960 / 64;
		public static final int LENGTH_ONE_THIRTY_TWO_BEAT = 960 / 32;
		public static final int LENGTH_ONE_SIXTEENTH_BEAT = 960 / 16;
		public static final int LENGTH_EIGHTH_BEAT = 960 / 8;
		public static final int LENGTH_FIFTH_BEAT = 960 / 5;
		public static final int LENGTH_QUARTER_BEAT = 960 / 4;
		public static final int LENGTH_THIRD_BEAT = 960 / 3;
		public static final int LENGTH_SECOND_BEAT = 960 / 2;
		public static final int LENGTH_ONE_BEAT =  960 / 1;
	}

	private int mForce;
	private int mLength;
	
	public int getForce() {
		return mForce;
	}

	public void setForce(int mForce) {
		this.mForce = mForce;
	}

	public int getLength() {
		return mLength;
	}

	public void setLength(int mLength) {
		this.mLength = mLength;
	}

	@Override
	public String getTypeName() {
		// TODO Auto-generated method stub
		return "Cadence";
	}
}
