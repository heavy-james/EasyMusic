package com.irrene.easymusic.test.bean;

import com.irrene.easymusic.bean.Key;
import com.irrene.easymusic.bean.Sound;
import com.irrene.easymusic.global.debug.LogUtil;

public class KeyTest extends TestCase{
	public static final String TAG = "KeyTest";

	@Override
	public void run() {
		Key c_major = new Key.Builder(new Sound(Sound.SOUND_C, null), Key.Attribute.DIATONIC_MAJOR).build();
		LogUtil.d(TAG, "c_major-->" + c_major.toString());
		Key c_minor = new Key.Builder(new Sound(Sound.SOUND_A, null), Key.Attribute.DIATONIC_MINOR).build();
		LogUtil.d(TAG, "a_minor-->" + c_minor.toString());
	}

}
