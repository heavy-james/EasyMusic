package com.irene.easymusic.bean;

import java.util.List;

public class Section extends Node{
	
	public List<Node> getChildren(){
		return null;
	}
	
	public Node getChild(int position){
		return null;
	}
	
	public void addChild(Node node,int position){
		
	}
	
	public int getLength(){
		return 0;
	}

	@Override
	public String getTypeName() {
		// TODO Auto-generated method stub
		return "Section";
	}

}
