package com.irene.easymusic.dtd.parser;

import java.util.ArrayList;
import java.util.List;

public class AttriInfo {

	public static final int ATTRI_REQURED = 1;
	public static final int ATTRI_IMPLIED = 2;
	public static final int ATTRI_FIXED = 3;

	public static final int TYPE_TEXT = 1;
	// type "CDATA"
	public static final int TYPE_CDATA = 2;
	// type "ID"
	public static final int TYPE_ID = 3;
	// type "IDREF"
	public static final int TYPE_IDREF = 4;
	// type "IDREFS"
	public static final int TYPE_IDREFS = 5;
	// type "NMTOKEN"
	public static final int TYPE_NMTOKEN = 6;
	// type "NMTOKENS"
	public static final int TYPE_NMTOKENS = 7;
	// type "NOTATION"
	public static final int TYPE_NOTATION = 8;
	//type "entity reference"
	public static final int TYPE_ENTITY_REFERENCE = 9;
	

	public static int parseAttriType(String typeName) throws DTDException {
		if ("CDATA".equals(typeName)) {
			return TYPE_ID;
		} else if ("ID".equals(typeName)) {
			return TYPE_ID;
		} else if ("IDREF".equals(typeName)) {
			return TYPE_IDREF;
		} else if ("IDREFS".equals(typeName)) {
			return TYPE_IDREFS;
		} else if ("NMTOKEN".equals(typeName)) {
			return TYPE_NMTOKEN;
		} else if ("NMTOKENS".equals(typeName)) {
			return TYPE_NMTOKENS;
		} else if ("NMTOKENS".equals(typeName)) {
			return TYPE_NOTATION;
		} else {
			throw new DTDException(DTDException.ERROR_CODE_DEFINITION_NOT_FOUND,
					DTDException.ERROR_MSG_DEFINITION_NOT_FOUND);
		}
	}

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
