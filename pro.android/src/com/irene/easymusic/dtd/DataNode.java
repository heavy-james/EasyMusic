package com.irene.easymusic.dtd;

import android.text.TextUtils;

public class DataNode {
	public static final int EXISTENCE_FLAG_ANY = 0x00000000;
	public static final int EXISTENCE_FLAG_NOT_NULL = 0x00000001;
	public static final int EXISTENCE_FLAG_ONCE = 0x00000010;
	public static final int EXISTENCE_FLAG_ONLY_ONCE = 0x00000011;

	public static final int DATA_TYPE__TEXT_DATA = 0x00000000;
	public static final int DATA_TYPE_PARSABLE_DATA = 0x00000001;

	public static final int NODE_TYPE_ATTRIBUTE = 1;
	public static final int NODE_TYPE_COMMENT = 2;
	public static final int NODE_TYPE_ELEMENT = 3;
	public static final int NODE_TYPE_ENTITY = 4;
	public static final int NODE_TYPE_ENTITY_REFERENCE = 5;

	private int mExistenceFlag = 0;
	private int mTypeFlag = 0;
	private boolean mIsValid = false;
	private String mTemplateName;
	private Object mData;

	public DataNode(String templateName, int typeFlag, int existenceFlag, Object data) {
		mTemplateName = templateName;
		mTypeFlag = typeFlag;
		mExistenceFlag = existenceFlag;
		mData = data;
		checkIsValid();
	}

	private void checkIsValid() {
		if (!TextUtils.isEmpty(mTemplateName)) {
			if ((mExistenceFlag & EXISTENCE_FLAG_NOT_NULL) > 0 && mData == null) {
				mIsValid = false;
			} else {
				mIsValid = true;
			}
		}
	}

	public boolean isValid() {
		return mIsValid;
	}

	public int getTypeFlag() {
		return mTypeFlag;
	}

	public String getTemplateName() {
		return mTemplateName;
	}

	public int getExistenceFlag() {
		return mExistenceFlag;
	}

	public boolean hasParsableData() {
		return (mTypeFlag & DATA_TYPE_PARSABLE_DATA) > 0;
	}
}
