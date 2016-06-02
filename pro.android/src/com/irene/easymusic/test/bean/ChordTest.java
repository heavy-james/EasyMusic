package com.irene.easymusic.test.bean;

import com.irene.easymusic.bean.Chord;
import com.irene.easymusic.bean.Sound;
import com.irene.easymusic.global.debug.LogUtil;

public class ChordTest extends TestCase{

	public static final String TAG = "ChordTest";
	
	@Override
	public void run() {
		Sound sound = new Sound();
		sound.setName(Sound.SOUND_C);
		Chord chord = new Chord.Builder(sound, Chord.Attribute.Three.ATTRI_MAJOR_3).build();
		LogUtil.d(TAG, chord.toString());
	}

}
