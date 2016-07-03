package com.irene.easymusic.dtd.parser;

import java.util.LinkedList;
import java.util.List;

public class DTDNode {
	public static final int EXISTENCE_FLAG_ANY = 0x00000000;
	public static final int EXISTENCE_FLAG_NOT_NULL = 0x00000001;
	public static final int EXISTENCE_FLAG_ONCE = 0x00000010;
	public static final int EXISTENCE_FLAG_ONLY_ONCE = 0x00000011;

	public static final int DATA_TYPE_TEXT_DATA = 0x00000000;
	public static final int DATA_TYPE_PARSABLE_DATA = 0x00000001;

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
	private String mData;
	private int mDataType = DATA_TYPE_TEXT_DATA;

	public DTDNode(int typeFlag,String name) {
		mName = name;
		mTypeFlag = typeFlag;
		checkIsValid();
	}

	public void addChild(DTDNode node){
		if(node != null){
			if(mChilds == null){
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
	
	public String getData(){
		return mData;
	}
	
	public void setData(String data){
		this.mData = data;
	}
	
	public int getDataType(){
		return mDataType;
	}

	public String getName() {
		return mName;
	}

	public int getExistenceFlag() {
		return mExistenceFlag;
	}

	public boolean hasParsableData() {
		return (mTypeFlag & DATA_TYPE_PARSABLE_DATA) > 0;
	}
}
