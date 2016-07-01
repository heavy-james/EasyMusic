package com.irene.easymusic.dtd.parser;

public class DTDNode {
	
	public static final int ATTRIBUTE = 1;
	public static final int COMMENT = 2;
	public static final int ELEMENT = 3;
	public static final int ENTITY = 4;
	public static final int ENTITY_REFERENCE = 5;
	
	private int mNodeType;
	private String mNodeData;
	
	public DTDNode(int type,String data){
		mNodeType = type;
		mNodeData = data;
	}
	
	public int getNodeType(){
		return mNodeType;
	}
	
	public String getNodeData(){
		return mNodeData;
	}
}
