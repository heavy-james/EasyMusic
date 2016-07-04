package com.irene.easymusic.dtd.parser;

public class DTDException extends Throwable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int ERROR_CODE_FORMAT = 1;
	
	public static final int ERROR_CODE_DEFINITION_NOT_FOUND = 2;
	
	public static final String ERROR_MSG_FORMAT = "DTD file format error";
	
	public static final String ERROR_MSG_DEFINITION_NOT_FOUND = "definition not found";
	
	public DTDException(int errorCode,String errorMsg){
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}
	
	public int errorCode;
	
	public String errorMsg;
	
}
