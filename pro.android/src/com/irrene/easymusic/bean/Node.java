package com.irrene.easymusic.bean;


public abstract class Node {
	
	public void display(MediaPlayer player){
		
	}
	
	public void draw(Canvas canvas,Position pos){
		
	}
	
	abstract public String getTypeName();
	
	public Size getSize(){
		return Size.make(0, 0);
	}
	
	public Node getChild(){
		return null;
	}
	
	public Node getParent(){
		return null;
	}
}
