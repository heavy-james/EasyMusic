package com.irrene.easymusic.test.bean;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.xmlpull.v1.XmlPullParserException;

import com.irrene.easymusic.bean.NumberedNotation;
import com.irrene.easymusic.bean.utils.NumberedNotationXMLParser;
import com.irrene.easymusic.global.debug.LogUtil;
import com.irrene.easymusic.utils.io.FileUtils;

public class NumberNotationTest extends TestCase{
	public static final String TAG = "NumberNotationTest";

	@Override
	public void run() {
		InputStream is = null;
		try {
			NumberedNotationXMLParser parser = new NumberedNotationXMLParser();
			is = FileUtils.readFileToStream("/sdcard/easymusic/xiaoxingxing.xml");
			LogUtil.e(TAG, "run start is-->" + is);
			NumberedNotation notation = parser.parse(is);
			LogUtil.e(TAG, "run start notation-->" + notation);
			String result = parser.serialize(notation);
			LogUtil.e(TAG, "run start result-->" + result);
			if(result != null){
				FileUtils.restoreStringToFile("/sdcard/easymusic/xiaoxingxing_bak.xml", result);
			}
		} catch (FileNotFoundException e) {
			LogUtil.e(TAG, "run FileNotFoundException-->" + e.getMessage());
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			LogUtil.e(TAG, "run XmlPullParserException-->" + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			LogUtil.e(TAG, "run IOException-->" + e.getMessage());
			e.printStackTrace();
		}finally{
			if(is != null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
