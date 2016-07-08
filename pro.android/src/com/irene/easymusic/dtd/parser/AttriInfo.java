package com.irene.easymusic.dtd.parser;

import java.util.ArrayList;
import java.util.List;

public class AttriInfo {

	public static final int ATTRI_REQURED = 1;
	public static final int ATTRI_IMPLIED = 2;
	public static final int ATTRI_FIXED = 3;


	private String mElementName;
	private String mAttriName;
	private String mDefualtValue;
	private int mType;
	private String mExpression;
	private int mExistenceFlag = ATTRI_IMPLIED;
	private List<String> mAttrisValues;

	public AttriInfo(String elementName, int type, String atttriName) {
		mElementName = elementName;
		mAttriName = atttriName;
		mType = type;
	}

	public String getElementName() {
		return mElementName;
	}

	public String getAttriName() {
		return mAttriName;
	}

	public List<String> getAttriValues() {
		return mAttrisValues;
	}

	public void setDefaultVaule(String defaultValue) {
		mDefualtValue = defaultValue;
	}

	public String getDefaultValue() {
		return mDefualtValue;
	}

	public void setExpression(String expression) {
		mExpression = expression;
	}

	public String getExpression() {
		return mExpression;
	}

	public void setExistenceFlag(int existenceFlag) {
		mExistenceFlag = existenceFlag;
	}

	public int getExistenceFlag() {
		return mExistenceFlag;
	}

	public void addAttriValue(String value) {
		if (mAttrisValues == null) {
			mAttrisValues = new ArrayList<String>();
		}
		if (!mAttrisValues.contains(value)) {
			mAttrisValues.add(value);
		}
	}
}
