package com.irene.easymusic.bean.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.irene.easymusic.bean.NumberedNotation;
import com.irene.easymusic.bean.NumberedNotation.Paragraph;
import com.irene.easymusic.bean.NumberedNotation.Sentence;
import com.irene.easymusic.global.debug.LogUtil;
import com.irene.easymusic.utils.format.XMLParser;

import android.util.Xml;

public class NumberedNotationXMLParser implements XMLParser<NumberedNotation>{
	
	public static final String TAG = "NumberedNotationXMLParser";

	@Override
	public NumberedNotation parse(InputStream is) throws XmlPullParserException, IOException {
		
		if(is == null){
			LogUtil.d(TAG, "parse input stream is null,return null");
			return null;
		}
		
		XmlPullParser parser = Xml.newPullParser();
		NumberedNotation notation = null;
		Paragraph paragraph = null;
		Sentence sentence = null;
		parser.setInput(is, "utf-8");
		int eventType = parser.getEventType();
		while(eventType != XmlPullParser.END_DOCUMENT){
			switch(eventType){
			case XmlPullParser.START_DOCUMENT:
				notation = new NumberedNotation();
				LogUtil.d(TAG, "parse START_DOCUMENT");
				break;
			case XmlPullParser.START_TAG:  
                if (parser.getName().equals(NumberedNotation.TAG_NAME_SONG)) { 
                	notation.mSongName = parser.getAttributeValue(NumberedNotation.NAME_SPACE, NumberedNotation.PROP_NAME_NAME);
                	notation.mKey = parser.getAttributeValue(NumberedNotation.NAME_SPACE, NumberedNotation.PROP_NAME_KEY);
                	notation.mKeyAttri = parser.getAttributeValue(NumberedNotation.NAME_SPACE, NumberedNotation.PROP_NAME_KEY_ATTRI);
                	notation.mRhythm = parser.getAttributeValue(NumberedNotation.NAME_SPACE, NumberedNotation.PROP_NAME_RHYTHM);
                	notation.mSpeed = parser.getAttributeValue(NumberedNotation.NAME_SPACE, NumberedNotation.PROP_NAME_SPEED);
                	notation.mKeyType = parser.getAttributeValue(NumberedNotation.NAME_SPACE, NumberedNotation.PROP_NAME_KEY_TYPE);
                	notation.mRhythmType = parser.getAttributeValue(NumberedNotation.NAME_SPACE, NumberedNotation.PROP_NAME_RHYTHM_TYPE);
                	notation.mPartType = parser.getAttributeValue(NumberedNotation.NAME_SPACE, NumberedNotation.PROP_NAME_PART_TYPE);
                } else if (parser.getName().equals(NumberedNotation.Paragraph.TAG_NAME_PARAGRAPH)) {
                	paragraph = new Paragraph();
                	paragraph.mPartAttri = parser.getAttributeValue(NumberedNotation.NAME_SPACE, NumberedNotation.Paragraph.PROP_NAME_PART);
                	paragraph.mReaptAttri = parser.getAttributeValue(NumberedNotation.NAME_SPACE, NumberedNotation.Paragraph.PROP_NAME_REPEAT);
                }else if(parser.getName().equals(NumberedNotation.Sentence.TAG_NAME_SENTENCE)){
                	sentence = new Sentence();
                }else if (parser.getName().equals(NumberedNotation.Sentence.TAG_NAME_MELODY)) {
                	sentence.mMelody = parser.nextText();
                	LogUtil.d(TAG, "START_TAG -->" + NumberedNotation.Sentence.TAG_NAME_MELODY + ", text-->" + sentence.mMelody);
                } else if (parser.getName().equals(NumberedNotation.Sentence.TAG_NAME_LYRICS)) { 
                	sentence.mLyrics = parser.nextText();
                	LogUtil.d(TAG, "START_TAG -->" + NumberedNotation.Sentence.TAG_NAME_LYRICS + ", text-->" + sentence.mLyrics);
                }  
                break;  
			case XmlPullParser.END_TAG: 
				if(parser.getName().equals(NumberedNotation.Paragraph.TAG_NAME_PARAGRAPH)){
					notation.mParagraphs.add(paragraph);
				}else if(parser.getName().equals(NumberedNotation.Sentence.TAG_NAME_SENTENCE)){
					paragraph.mSentences.add(sentence);
				}
                break;  
            }  
            eventType = parser.next();
		}
		return notation;
	}

	@Override
	public String serialize(NumberedNotation notation) throws IllegalArgumentException, IllegalStateException, IOException {
		
		if(notation == null){
			LogUtil.d(TAG, "serialize notation is null, return null");
			return null;
		}
		
		XmlSerializer serializer = Xml.newSerializer();
		StringWriter strwirter = new StringWriter();
		serializer.setOutput(strwirter);
		serializer.startDocument("utf-8", true);
		serializer.startTag(NumberedNotation.NAME_SPACE_NULL, NumberedNotation.TAG_NAME_SONG);
		serializer.attribute(NumberedNotation.NAME_SPACE, NumberedNotation.PROP_NAME_KEY, notation.mKey);
		serializer.attribute(NumberedNotation.NAME_SPACE, NumberedNotation.PROP_NAME_KEY_ATTRI, notation.mKeyAttri);
		serializer.attribute(NumberedNotation.NAME_SPACE, NumberedNotation.PROP_NAME_KEY_TYPE, notation.mKeyType);
		serializer.attribute(NumberedNotation.NAME_SPACE, NumberedNotation.PROP_NAME_PART_TYPE, notation.mPartType);
		serializer.attribute(NumberedNotation.NAME_SPACE, NumberedNotation.PROP_NAME_RHYTHM, notation.mRhythm);
		serializer.attribute(NumberedNotation.NAME_SPACE, NumberedNotation.PROP_NAME_RHYTHM_TYPE, notation.mRhythmType);
		serializer.attribute(NumberedNotation.NAME_SPACE, NumberedNotation.PROP_NAME_NAME, notation.mSongName);
		serializer.attribute(NumberedNotation.NAME_SPACE, NumberedNotation.PROP_NAME_SPEED, notation.mSpeed);
		for(Paragraph para : notation.mParagraphs){
			serializer.startTag(NumberedNotation.NAME_SPACE_NULL, NumberedNotation.Paragraph.TAG_NAME_PARAGRAPH);
			serializer.attribute(NumberedNotation.NAME_SPACE_NULL, NumberedNotation.Paragraph.PROP_NAME_PART, para.mPartAttri);
			serializer.attribute(NumberedNotation.NAME_SPACE_NULL, NumberedNotation.Paragraph.PROP_NAME_REPEAT, para.mReaptAttri);
			for(Sentence sentence : para.mSentences){
				serializer.startTag(NumberedNotation.NAME_SPACE_NULL, NumberedNotation.Sentence.TAG_NAME_SENTENCE);
				serializer.startTag(NumberedNotation.NAME_SPACE_NULL, NumberedNotation.Sentence.TAG_NAME_MELODY);
				serializer.text(sentence.mMelody);
				serializer.endTag(NumberedNotation.NAME_SPACE_NULL, NumberedNotation.Sentence.TAG_NAME_MELODY);
				serializer.startTag(NumberedNotation.NAME_SPACE_NULL, NumberedNotation.Sentence.TAG_NAME_LYRICS);
				serializer.text(sentence.mLyrics);
				serializer.endTag(NumberedNotation.NAME_SPACE_NULL, NumberedNotation.Sentence.TAG_NAME_LYRICS);
				serializer.endTag(NumberedNotation.NAME_SPACE_NULL, NumberedNotation.Sentence.TAG_NAME_SENTENCE);
			}
			serializer.endTag(NumberedNotation.NAME_SPACE_NULL, NumberedNotation.Paragraph.TAG_NAME_PARAGRAPH);
		}
		serializer.endTag(NumberedNotation.NAME_SPACE_NULL, NumberedNotation.TAG_NAME_SONG);
		serializer.endDocument();
		return strwirter.toString();
	}

}
