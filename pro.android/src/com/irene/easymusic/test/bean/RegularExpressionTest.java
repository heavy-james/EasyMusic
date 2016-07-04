package com.irene.easymusic.test.bean;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.util.Log;


public class RegularExpressionTest extends TestCase{
	
	public static final String TAG = "RegularExpressionTest";

	@Override
	public void run() {
		String TestString = "<!ATTLIST staff-details" +
				"number         CDATA                #IMPLIED" +
				"show-frets     (numbers | letters)  #IMPLIED" +
				"%print-object;" +
				"%print-spacing;" +
				"xml:lang NMTOKEN #IMPLIED>";
		String patternString = "<!ATTLIST \\b (\\w+(-\\w+)*) \\b ((\\w+(-\\w+)*)"
		+ "\\b (CDATA | \\( (\\w+(-\\w+)*\\|)* (\\w+(-\\w+)*\\|)+ \\) ) | ID | IDREF | IDREFS | NMTOKEN | NMTOKENS | NOTATION | xml:\\w+)"
		+ "\\b	((\\w+(-\\w+)*\\|)* | #REQUIRED | #IMPLIED | #FIXED\\w*) | (%(\\w+(-\\w+)*;))* >";
		
		Matcher matcher = Pattern.compile(patternString, Pattern.MULTILINE).matcher(TestString);
		Log.d(TAG, "matcher result-->" + matcher.matches());
	}
	
}
