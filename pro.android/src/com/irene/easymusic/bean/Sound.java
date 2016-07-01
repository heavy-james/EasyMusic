package com.irene.easymusic.bean;

public class Sound extends Node {

	private int mName;
	private Cadence mCadence;
	public static final int SOUND_BLANK = 0;
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
	


	private static final String[] SOUND_NAMES_MARK_UP = { "A", "#A", "B", "C",
			"#C", "D", "#D", "E", "F", "#F", "G,", "#G" };

	private static final String[] SOUND_NAMES_MARK_DOWN = { "A", "bA", "B",
			"C", "bD", "D", "bE", "E", "F", "bG", "G,", "bA" };

	public boolean isValide() {
		return mName >= SOUND_A_DOWN_DOUBLE && mName <= SOUND_A_UP_DOUBLE;
	}

	public Sound(int name, Cadence cadence) {
		mName = name;
		mCadence = cadence;
	}

	public static int getName(String soundName) {
		for (int i = 0; i < SOUND_NAMES_MARK_UP.length; i++) {
			if (SOUND_NAMES_MARK_UP[i].equalsIgnoreCase(soundName)
					|| SOUND_NAMES_MARK_DOWN[i].equalsIgnoreCase(soundName)) {
				return SOUND_A + i;
			}
		}
		return 0;
	}

	public String getSoundName() {
		return getSoundName(mName);
	}

	public static String getSoundName(int name) {

		if (name < 1 || name > 49) {
			return "";
		}
		String suffix = "";
		switch (name / 12) {
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
		String soundName = SOUND_NAMES_MARK_UP[(name - 1) % 12];
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
	
	public int getLength(){
		if(null != mCadence){
			return mCadence.getLength();
		}
		return 0;
	}

	public void setCadence(Cadence mCadence) {
		this.mCadence = mCadence;
	}

	public String toString() {
		String result = "sound value-->" + mName + "; sound name-->"
				+ getSoundName();
		if (mCadence != null) {
			result += mCadence.toString();
		}
		result += "; \n";
		return result;
	}

	@Override
	public String getTypeName() {
		// TODO Auto-generated method stub
		return "Sound";
	}

}
