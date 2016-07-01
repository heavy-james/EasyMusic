package com.irene.easymusic.dtd;

public interface Entity {
	
	public static final int EXISTENCE_FLAG_ANY = 0x00000000;
	public static final int EXISTENCE_FLAG_NOT_NULL = 0x00000001;
	public static final int EXISTENCE_FLAG_ONCE = 0x00000010;
	public static final int EXISTENCE_FLAG_ONLY_ONCE = 0x00000011;
	
	public static final int TYPE_FLAG_TEXT_DATA = 0x00000000;
	public static final int TYPE_FLAG_PARSABLE_DATA = 0x00000001;
	
	int getExistence();
	int getDataType();
	String parseValue(String valueName);
}
