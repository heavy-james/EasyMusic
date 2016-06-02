package com.irene.easymusic.bean;

public class Sound extends Node{
	
	private int mName;
	private Cadence mCadence;
	public static final int SOUND_A_UP = 49;
	public static final int SOUND_B_UP = 51;
	public static final int SOUND_C_UP = 52;
	public static final int SOUND_D_UP = 54;
	public static final int SOUND_E_UP = 56;
	public static final int SOUND_F_UP = 57;
	public static final int SOUND_G_UP = 59;
	public static final int SOUND_A_UP_DOUBLE = 37;
	public static final int SOUND_B_UP_DOUBLE = 39;
	public static final int SOUND_C_UP_DOUBLE = 40;
	public static final int SOUND_D_UP_DOUBLE = 42;
	public static final int SOUND_E_UP_DOUBLE = 44;
	public static final int SOUND_F_UP_DOUBLE = 45;
	public static final int SOUND_G_UP_DOUBLE = 47;
	public static final int SOUND_A = 25;
	public static final int SOUND_B = 27;
	public static final int SOUND_C = 28;
	public static final int SOUND_D = 30;
	public static final int SOUND_E = 32;
	public static final int SOUND_F = 33;
	public static final int SOUND_G = 35;
	public static final int SOUND_A_DOWN = 13;
	public static final int SOUND_B_DOWN = 15;
	public static final int SOUND_C_DOWN = 16;
	public static final int SOUND_D_DOWN = 18;
	public static final int SOUND_E_DOWN = 20;
	public static final int SOUND_F_DOWN = 21;
	public static final int SOUND_G_DOWN = 23;
	public static final int SOUND_A_DOWN_DOUBLE = 1;
	public static final int SOUND_B_DOWN_DOUBLE = 3;
	public static final int SOUND_C_DOWN_DOUBLE = 4;
	public static final int SOUND_D_DOWN_DOUBLE = 6;
	public static final int SOUND_E_DOWN_DOUBLE = 8;
	public static final int SOUND_F_DOWN_DOUBLE = 9;
	public static final int SOUND_G_DOWN_DOUBLE = 11;
	
	private static final String[] SOUND_NAMES = {
			"A","#A","B","C","#C","D","#D","E","F","#F","G,","#G"
	};
	
	
	
	public  String getSoundName(){
		
		if(mName < 1 || mName > 49){
			return "";
		}
		String suffix = "";
		switch(mName / 12){
		case 0:
			suffix = "_DD";
			break;
		case 1:
			suffix = "_D";
			break;
		case 2:
			suffix = "";
			break;
		case 3:
			suffix = "_U";
			break;
		case 4:
			suffix = "_UU";
			break;
		}
		String soundName = SOUND_NAMES[mName -1 % 12];
		soundName += suffix;
		return soundName;
	}
	
	public int getName() {
		return mName;
	}



	public void setName(int mName) {
		this.mName = mName;
	}


	public Cadence getCadence() {
		return mCadence;
	}



	public void setCadence(Cadence mCadence) {
		this.mCadence = mCadence;
	}



	@Override
	public String getTypeName() {
		// TODO Auto-generated method stub
		return "Sound";
	}
	
}
