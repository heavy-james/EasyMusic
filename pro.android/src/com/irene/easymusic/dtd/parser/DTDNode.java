package com.irene.easymusic.dtd.parser;

import java.util.LinkedList;
import java.util.List;

public class DTDNode {
	public static final int EXISTENCE_FLAG_ANY = 0x00000000;
	public static final int EXISTENCE_FLAG_NOT_NULL = 0x00000001;
	public static final int EXISTENCE_FLAG_ONCE = 0x00000010;
	public static final int EXISTENCE_FLAG_ONLY_ONCE = 0x00000011;

	public static final int NODE_TYPE_ATTRIBUTE = 1;
	public static final int NODE_TYPE_COMMENT = 2;
	public static final int NODE_TYPE_ELEMENT = 3;
	public static final int NODE_TYPE_ENTITY = 4;
	public static final int NODE_TYPE_ENTITY_REFERENCE = 5;

	private int mExistenceFlag = 0;
	private int mTypeFlag = 0;
	private boolean mIsValid = false;
	private String mName;
	private List<DTDNode> mChilds;
	private String mStrData;
	
	/**
	 * restore data for different node
	 * 
	 * NODE_TYPE_ATTRIBUTE is List<Attri>
	 */
	private Object mObjData;
	
	
	private int mDataType = DTDConstants.DataType.TEXT;
	private String mDTDDocument;

	public DTDNode(int typeFlag, String name, String documentName) {
		mDTDDocument = documentName;
		mName = name;
		mTypeFlag = typeFlag;
		checkIsValid();
	}

	public void addChild(DTDNode node) {
		if (node != null) {
			if (mChilds == null) {
				mChilds = new LinkedList<DTDNode>();
			}
			mChilds.add(node);
		}

	}

	private void checkIsValid() {
	}

	public boolean isValid() {
		return mIsValid;
	}

	public int getNodeType() {
		return mTypeFlag;
	}

	public String getStringData() {
		return mStrData;
	}

	public void setStringData(String dataStr) {
		this.mStrData = dataStr;
	}
	
	public Object getObjData(){
		return mObjData;
	}

	public void setObjData(Object dataObj){
		mObjData = dataObj;
	}
	
	public int getDataType() {
		return mDataType;
	}

	public String getName() {
		return mName;
	}

	public int getExistenceFlag() {
		return mExistenceFlag;
	}

	public boolean hasParsableData() {
		return !(mTypeFlag == DTDConstants.DataType.CDATA || mTypeFlag == DTDConstants.DataType.TEXT);
	}
}
