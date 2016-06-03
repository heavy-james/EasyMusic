package com.irene.easymusic.test.bean;

import com.irene.easymusic.bean.Chord;
import com.irene.easymusic.bean.Sound;
import com.irene.easymusic.global.debug.LogUtil;

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
