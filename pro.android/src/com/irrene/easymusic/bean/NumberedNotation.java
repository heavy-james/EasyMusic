package com.irrene.easymusic.bean;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

/**
 * 
 * @author zhanhaifei 
 * 歌曲 SongName=歌曲名称 
 * Key=歌曲调子
 * KeyAttri=大小调属性 
 * Rhythm=节拍
 * Speed=速度(拍数/分)
 * 音阶 1234567 高八度记号_U,低八度记号_D,高十六度记号_UU,低十六度记号_DD 
 * 拍子 无标记一拍，[-]延音线一拍， | 小节线，[_]半时记号， [.]附点音符， 【&**&】连音线，0休止符
 * 	由上级信息传递，用来初始化下级对象数据，取用时检查标志位，并且逐级验证，以下级对象数据对象为准。强弱关系等复杂变化的关系，可以在表达时动态确定。
 */

public class NumberedNotation {

	public static final String TAG = "NumberedNotation";
	public static final String NAME_SPACE = "http://com.irrene.easymusic/ns/numbered_notation";
	public static final String NAME_SPACE_NULL = null;
	public static final String SIMBOL_ADD_TIME = "-";
	public static final String SIMBOL_SUB_TIME = "_";
	public static final String SIMBOL_SEPRATOR = "|";
	public static final String SIMBOL_ADD_HALF_TIME = ".";
	public static final String SIMBOL_CONNECT = "&";
	public static final String SIMBOL_BLANK = "0";
	public static final String TAG_NAME_SONG = "song";
	public static final String PROP_NAME_NAME = "name";
	public static final String PROP_NAME_KEY = "key";
	public static final String PROP_NAME_RHYTHM = "rhythm";
	public static final String PROP_NAME_KEY_ATTRI = "key_attri";
	public static final String PROP_NAME_SPEED = "speed";
	public static final String PROP_NAME_RHYTHM_TYPE = "rhythm_type";
	public static final String PROP_NAME_PART_TYPE = "part_type";
	public static final String PROP_NAME_KEY_TYPE = "key_type";
	public static final String VALUE_NAME_SINGLE = "single";
	public static final String VALUE_NAME_MULTIPLE = "multiple";

	public String mSongName = "";
	public String mKey = "";
	public String mKeyAttri = "";
	public String mSpeed = "";
	public String mRhythm = "";
	public String mKeyType = "";
	public String mRhythmType = "";
	public String mPartType = "";
	public List<Paragraph> mParagraphs = null;
	
	public NumberedNotation(){
		mParagraphs = new ArrayList<NumberedNotation.Paragraph>();
	}
	
	public static class Paragraph{
		public static final String TAG_NAME_PARAGRAPH = "paragraph";
		public static final String PROP_NAME_PART = "part";
		public static final String PROP_NAME_REPEAT = "repeat";
		
		public String mPartAttri = "";
		public String mReaptAttri = "";
		public List<Sentence> mSentences= new ArrayList<NumberedNotation.Sentence>();
	}
	
	public static class Sentence{
		public static final String TAG_NAME_MELODY = "melody";
		public static final String TAG_NAME_LYRICS = "lyrics";
		public static final String TAG_NAME_SENTENCE = "sentence";
		public String mMelody = "";
		public String mLyrics = "";
	}
	
	public Song translateToSong(){
		Key key = new Key.Builder(mKey, mKeyAttri).build();
		Pattern pattern = Pattern.create(mRhythm);
		int speed = Integer.parseInt(mSpeed);
		Song song  = new Song(mSongName, key, pattern, speed);
		for(Paragraph paragraph : mParagraphs){
			MusicParagraph mp = parseParagraph(paragraph, key, pattern);
			song.addParagraph(mp);
		}
		return song;
	}
	
	public MusicParagraph parseParagraph(Paragraph paragraph,Key key,Pattern pattern){
		int partAttri = Integer.parseInt(paragraph.mPartAttri);
		boolean repeat = Boolean.parseBoolean(paragraph.mReaptAttri);
		MusicParagraph mp = new MusicParagraph(key.getKeyValue(), partAttri, repeat);
		for(Sentence sentence : paragraph.mSentences){
			MusicSentence ms = parseSentence(sentence, key, pattern);
			mp.addSentence(ms);
		}
		return mp;
	}
	
	public MusicSentence parseSentence(Sentence sentence,Key key,Pattern pattern){
		String[] melodyUnits = sentence.mMelody.split("|");
		String[] lyricUnits = sentence.mLyrics.split("|");
		if(melodyUnits.length == lyricUnits.length){
			for(int i = 0; i < melodyUnits.length; i++){
				String melody = melodyUnits[i];
				String lyric = lyricUnits[i];
				MusicUnit unit = new MusicUnit.Builder(pattern).build();
			}
		}
		return null;
	}
	
	public List<Sound> parseSounds(int key, Pattern pattern,String soundStr){
		List<Sound> result = new LinkedList<Sound>();
		return result;
	}
	
	public List<Word> parseWords(int key,Pattern pattern,String wordStr){
		List<Word> result = new LinkedList<Word>();
		return result;
	}

}
