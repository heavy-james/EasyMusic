package com.irene.easymusic.dtd.parser;

public class EntityInfo {
	public static final int TYPE_VALUES_ONLY = 1;
	public static final int TYPE_VALUES_WITH_NAME = 2;
	public static final int TYPE_COMPLEX_CONTENT = 3;
	public static final int TYPE_INSTRUMENT = 4;

	private String mName;
	private int mType;
	private String mDocumentName;
	private String mValue;
	private int mExistenceFlag = DTDNode.EXISTENCE_FLAG_ANY;

	public EntityInfo(int type, String name, String documentName) {
		mType = type;
		mName = name;
		mDocumentName = documentName;
	}

	public String getName() {
		return mName;
	}

	public String getValue() {
		return mValue;
	}

	public String getDocumentName() {
		return mDocumentName;
	}
	
	public int getExistence(){
		return mExistenceFlag;
	}
	
	public void setExistence(int existenceFlag){
		mExistenceFlag = existenceFlag;
	}

	public int getType() {
		return mType;
	}

	public void setValue(String value) {
		mValue = value;
	}
}
