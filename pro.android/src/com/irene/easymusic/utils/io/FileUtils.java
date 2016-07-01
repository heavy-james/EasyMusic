package com.irene.easymusic.utils.io;

import java.io.BufferedOutputStream;
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
	
	public static boolean restoreStringToFile(String fileName,String content){
		boolean result = false;
		FileOutputStream os = null;
		BufferedOutputStream bf = null;
		if(null != content){
			try {
				File file = new File(fileName);
				if(file.exists()){
					LogUtil.e(TAG, "restorePropsToFile delete old file-->" + fileName);
					file.delete();
				}
				file.createNewFile();
				if(file.canWrite()){
					LogUtil.e(TAG, "restorePropsToFile start to write file-->" + fileName);
					os = new FileOutputStream(file);
					bf = new BufferedOutputStream(os);
					byte[] bytes = content.getBytes();
					bf.write(bytes, 0, bytes.length);
					bf.flush();
					result = true;
					LogUtil.e(TAG, "restorePropsToFile complete to write file-->" + fileName);
				}else{
					LogUtil.e(TAG, "restorePropsToFile file is not writable-->" + fileName);
				}
			} catch (IOException e) {
				LogUtil.e(TAG, "restorePropsToFile -->" + e.getMessage());
				e.printStackTrace();
			}finally {
				if(bf != null){
					try {
						bf.close();
					} catch (IOException e) {
						LogUtil.e(TAG, "restorePropsToFile buffered output stream close error-->" + e.getMessage());
						e.printStackTrace();
					}
				}
				if(os != null){
					try {
						os.close();
					} catch (IOException e) {
						LogUtil.e(TAG, "restorePropsToFile output stream close error-->" + e.getMessage());
						e.printStackTrace();
					}
				}
			}
		}else{
			LogUtil.e(TAG, "restorePropsToFile content is null");
		}
		return result;
	}
	
	public static InputStream readFileToStream(String fileName) throws FileNotFoundException{
		InputStream is = new FileInputStream(new File(fileName));
		return is;
	}
	
}
