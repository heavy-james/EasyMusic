package com.irene.easymusic.bean;

import java.util.Properties;

/**
 * 
 * @author zhanhaifei 歌曲 SongName=歌曲名称 Key=歌曲调子 KeyAttri=大小调属性 Rhythm=节拍
 *         Speed=速度(拍数/分) PartAttri=声部 SinglePart=单声部 MultiPart=多声部
 *         SingleKey=单调子 MultiKey=变调子 SingleRhythm=单拍子 MultiRhythm=复拍子 音阶
 *         1234567 高八度记号_U,低八度记号_D,高十六度记号_UU,低十六度记号_DD 拍子 无标记一拍，[-]延音线一拍， | 小节线，
 *         [_]半时记号， [.]附点音符， 【&**&】连音线，0休止符
 */

public class NumberedNotation {

	public static final String TAG = "NumberedNotation";
	public static final String NAME_SPACE = "http://com.irrene.easymusic/ns/numbered_notation";
	public static final String PART = "Part";
	public static final String MELODY_PART = "MelodyPart";
	public static final String LYRICS_PART = "LyricsPart";
	public static final String SIMBOL_ADD_TIME = "-";
	public static final String SIMBOL_SUB_TIME = "_";
	public static final String SIMBOL_SEPRATOR = "|";
	public static final String SIMBOL_ADD_HALF_TIME = ".";
	public static final String SIMBOL_CONNECT = "&";
	public static final String SIMBOL_BLANK = "0";
	public static final String TAG_NAME_SONG = "song";
	public static final String TAG_NAME_PARAGRAPH = "paragraph";
	public static final String TAG_NAME_MELODY = "melody";
	public static final String TAG_NAME_LYRICS = "lyrics";
	public static final String PROP_NAME_SONG_NAME = "song_name";
	public static final String PROP_NAME_KEY = "key";
	public static final String PROP_NAME_RHYTHM = "rhythm";
	public static final String PROP_NAME_KEY_ATTRI = "key_attri";
	public static final String PROP_NAME_SPEED = "speed";
	public static final String PROP_NAME_RHYTHM_TYPE = "rhythm_type";
	public static final String PROP_NAME_REPEAT = "repeat";
	public static final String PROP_NAME_PART_TYPE = "part_type";
	public static final String PROP_NAME_KEY_TYPE = "key_type";
	public static final String VALUE_NAME_SINGLE = "single";
	public static final String VALUE_NAME_MULTIPLE = "multiple";

	// private String mFilePath = null;
	private String mSongName = null;
	private Key mKey;
	private int mSpeed = 0;
	private Pattern mPattern = null;
	private String mKeyType = null;
	private String mRhythmType = null;
	private String mPartType = null;
	private Melody mMelody = null;
	private Lyric mLyric = null;

	private NumberedNotation(Builder builder) {
		this.mSongName = builder.songName;
		this.mKey = builder.key;
		this.mPattern = builder.pattern;
		this.mSpeed = builder.speed;
		this.mKeyType = builder.keyType;
		this.mRhythmType = builder.rhythmType;
		this.mPartType = builder.partType;
		this.mMelody = new Melody();
		this.mLyric = new Lyric();

	}

	public String getSongName() {
		return mSongName;
	}

	public Key getkey() {
		return mKey;
	}

	public int getSpeed() {
		return mSpeed;
	}

	public Pattern getPattern() {
		return mPattern;
	}

	public String getKeyType() {
		return mKeyType;
	}

	public String getRhythmType() {
		return mRhythmType;
	}

	public String getPartType() {
		return mPartType;
	}

	public Melody getMelody() {
		return mMelody;
	}

	public Lyric getLyric() {
		return mLyric;
	}

	public static class Builder {
		private String songName = null;
		private Key key = null;
		private int speed = 0;
		private Pattern pattern = null;
		private String keyType = null;
		private String rhythmType = null;
		private String partType = null;

		public Builder(String songName, Key key, int keyAttri, Pattern pattern, int speed) {
			this.songName = songName;
			this.key = key;
			this.speed = speed;
			this.pattern = pattern;
		}

		public Builder keyType(String type) {
			this.keyType = type;
			return this;
		}

		public Builder rhythmType(String type) {
			this.rhythmType = type;
			return this;
		}

		public Builder partType(String type) {
			this.partType = type;
			return this;
		}
	}
}
