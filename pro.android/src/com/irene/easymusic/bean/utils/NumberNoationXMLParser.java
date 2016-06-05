package com.irene.easymusic.bean.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import com.irene.easymusic.bean.Key;
import com.irene.easymusic.bean.Lyric;
import com.irene.easymusic.bean.Melody;
import com.irene.easymusic.bean.MusicParagraph;
import com.irene.easymusic.bean.NumberedNotation;
import com.irene.easymusic.bean.Pattern;
import com.irene.easymusic.utils.format.XMLParser;
import android.util.Xml;

public class NumberNoationXMLParser implements XMLParser<NumberedNotation>{

	@Override
	public NumberedNotation parse(InputStream is) throws XmlPullParserException, IOException {
		XmlPullParser parser = Xml.newPullParser();
		parser.setInput(is, "utf-8");
		Key key = null;
		String keyName = "";
		String keyAttri = "";
		String keyType = null;
		Pattern pattern = null;
		String rhythm = null;
		String rhythmType = null;
		int moculer = 0;
		int dinorminator = 0;
		String partType = null;
		Melody melody = null;
		Lyric lyric = null;
		int speed = 0;
		List<MusicParagraph> paragraphs = new ArrayList<MusicParagraph>();
		MusicParagraph paragraph = null;
		int eventType = parser.getEventType();
		while(eventType != XmlPullParser.END_DOCUMENT){
			switch(eventType){
			case XmlPullParser.START_DOCUMENT:
				melody = new Melody();
				lyric = new Lyric();
				break;
			case XmlPullParser.START_TAG:  
                if (parser.getName().equals(NumberedNotation.TAG_NAME_SONG)) { 
                	keyName = parser.getAttributeValue(NumberedNotation.NAME_SPACE, NumberedNotation.PROP_NAME_KEY);
                	keyAttri = parser.getAttributeValue(NumberedNotation.NAME_SPACE, NumberedNotation.PROP_NAME_KEY_ATTRI);
                	rhythm = parser.getAttributeValue(NumberedNotation.NAME_SPACE, NumberedNotation.PROP_NAME_RHYTHM);
                	speed = Integer.parseInt(parser.getAttributeValue(NumberedNotation.NAME_SPACE, NumberedNotation.PROP_NAME_SPEED));
                	keyType = parser.getAttributeValue(NumberedNotation.NAME_SPACE, NumberedNotation.PROP_NAME_KEY_TYPE);
                	rhythmType = parser.getAttributeValue(NumberedNotation.NAME_SPACE, NumberedNotation.PROP_NAME_RHYTHM_TYPE);
                	partType = parser.getAttributeValue(NumberedNotation.NAME_SPACE, NumberedNotation.PROP_NAME_KEY_TYPE);
                	eventType = parser.next();  
                } else if (parser.getName().equals(NumberedNotation.TAG_NAME_PARAGRAPH)) {
                	paragraph = new MusicParagraph();
                	//paragraph.setmKey(mKey);
                    eventType = parser.next();  
                } else if (parser.getName().equals(NumberedNotation.TAG_NAME_MELODY)) {  
                    eventType = parser.next();  
                } else if (parser.getName().equals(NumberedNotation.TAG_NAME_LYRICS)) {  
                    eventType = parser.next();  
                }  
                break;  
			case XmlPullParser.END_TAG:  
                if (parser.getName().equals("book")) {  
                }  
                break;  
            }  
            eventType = parser.next();
		}
		return null;
	}

	@Override
	public String serialize(NumberedNotation t) {
		// TODO Auto-generated method stub
		return null;
	}

}
