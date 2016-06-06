package com.irrene.easymusic.test.bean;

import com.irrene.easymusic.bean.Chord;
import com.irrene.easymusic.bean.Sound;
import com.irrene.easymusic.global.debug.LogUtil;

public class ChordTest extends TestCase{

	public static final String TAG = "ChordTest";
	
	@Override
	public void run() {
		Sound sound = new Sound(Sound.SOUND_C, null);
		Chord chord = new Chord.Builder(sound, Chord.Attribute.Three.ATTRI_MAJOR_3).ReverseTag(Chord.ReverseLevel.LEVEL_ONE).build();
		if(chord != null){
			LogUtil.d(TAG, chord.toString());
		}
	}

}
