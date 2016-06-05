package com.irene.easymusic.utils.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.irene.easymusic.global.debug.LogUtil;

public class FileUtils {
	public static final String TAG = "FileUtils";
	
	public static Properties readFileToProps(String fileName){
		Properties props = new Properties();
		InputStream is = null;
		try {
			is = readFileToStream(fileName);
			if(null != is){
				props.load(is);
			}
		} catch (FileNotFoundException e) {
			LogUtil.e(TAG, "readFileToProps -->" + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			LogUtil.e(TAG, "readFileToProps -->" + e.getMessage());
			e.printStackTrace();
		}finally{
			if(null != is){
				try {
					is.close();
				} catch (Exception e) {
					LogUtil.e(TAG, "readFileToProps close inputstream error-->" + e.getMessage());
				}
			}
		}
		return props;
	}
	
	public static boolean restorePropsToFile(String fileName,String comment, Properties props){
		boolean result = false;
		FileOutputStream os = null;
		if(null != props){
			try {
				File file = new File(fileName);
				if(file.exists()){
					file.delete();
				}
				if(file.canWrite()){
					os = new FileOutputStream(file);
					props.store(os, comment);
					result = true;
				}
			} catch (IOException e) {
				LogUtil.e(TAG, "restorePropsToFile -->" + e.getMessage());
				e.printStackTrace();
			}finally {
				if(os != null){
					try {
						os.close();
					} catch (IOException e) {
						LogUtil.e(TAG, "restorePropsToFile output stream close error-->" + e.getMessage());
						e.printStackTrace();
					}
				}
			}
		}
		return result;
	}
	
	private static InputStream readFileToStream(String fileName) throws FileNotFoundException{
		InputStream is = new FileInputStream(new File(fileName));
		return is;
	}
	
}
