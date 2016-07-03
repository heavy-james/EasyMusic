package com.irene.easymusic.dtd.parser;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DTDDocument {
	private InputStream mInputStream;
	private BufferedInputStream mBufferedInputStream;
	private List<DTDNode> mDefinedNodes;
	private List<DTDNode> mEntitys;
	private List<DTDNode> mEntityReference;
	private byte[] mBuffer = new byte[1024];
	private String mCurrentParseString = null;
	private String mEncoding = null;
	private Pattern mAttriListPattern;
	private Pattern mEntityPattern;
	private Pattern mEntityReferencePattern;
	private Pattern mElementPattern;
	private DTDDocument() {

	}

	public static DTDDocument loadFile(String filePath, String encoding) throws FileNotFoundException, IOException {
		DTDDocument instance = new DTDDocument();
		File file = new File(filePath);
		instance.mInputStream = new FileInputStream(file);
		instance.mBufferedInputStream = new BufferedInputStream(instance.mInputStream);
		instance.mEncoding = encoding;
		instance.mDefinedNodes = new LinkedList<DTDNode>();
		instance.mEntitys = new LinkedList<DTDNode>();
		instance.mEntityReference = new LinkedList<DTDNode>();
		instance.mAttriListPattern = Pattern.compile("^ $", Pattern.MULTILINE); 
		instance.mEntityPattern = Pattern.compile("a", Pattern.MULTILINE); 
		instance.mEntityPattern = Pattern.compile("a", Pattern.MULTILINE); 
		instance.mEntityReferencePattern = Pattern.compile("a", Pattern.MULTILINE); 
		instance.mElementPattern = Pattern.compile("a", Pattern.MULTILINE);
		return instance;
	}

	public DTDNode getNextNode() throws DTDException{
		if(hasNextNode()){
			int startPos = mCurrentParseString.indexOf("<!");
			int endPos = mCurrentParseString.indexOf(">");
			String content = mCurrentParseString.substring(startPos, endPos);
			DTDNode node = null;
			if(content.startsWith("<!--") && content.endsWith("-->")){
				node = new DTDNode(DTDNode.NODE_TYPE_COMMENT, null);
				node.setData(content.substring("<!--".length(),content.length() - "-->".length()));
			}else if(content.startsWith("<!ATTLIST")){
				
			}else if(content.startsWith("<!ENTITY") && content.contains("%")){
				
			}else if(content.startsWith("<!ENTITY")){
				
			}else if(content.startsWith("<!ELEMENT")){
				
			}else{
				try {
					throw new DTDException(DTDException.ERROR_CODE_FORMAT, DTDException.ERROR_MSG_FORMAT);
				} catch (DTDException e) {
					e.printStackTrace();
				}
			}
			if(mCurrentParseString.length() >= endPos + 1){
				mCurrentParseString = mCurrentParseString.substring(endPos + 1, mCurrentParseString.length());
			}else{
				mCurrentParseString = null;
			}
		}
		return null;
	}

	public boolean hasNextNode() {
		if (mCurrentParseString == null || !contanisNode(mCurrentParseString)) {
			String temp = null;
			StringBuffer sb = new StringBuffer(mCurrentParseString);
			do {
				temp = readNextString();
				sb.append(temp);
			} while (temp != null && !contanisNode(sb.toString()));
			mCurrentParseString = sb.toString();
		}
		if (mCurrentParseString != null && contanisNode(mCurrentParseString)) {
			return true;
		}
		return false;
	}

	private boolean contanisNode(String data) {
		if (data != null) {
			if (data.contains("<!") && data.contains(">")) {
				return true;
			}
		}
		return false;
	}

	private String readNextString() {
		if (mBufferedInputStream != null) {
			try {
				int length = mBufferedInputStream.read(mBuffer);
				if (length != -1) {
					return new String(mBuffer, mEncoding);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public void release() throws IOException {
		if (mBufferedInputStream != null) {
			mBufferedInputStream.close();
		}
		if (mInputStream != null) {
			mInputStream.close();
		}
	}
}
