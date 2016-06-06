package com.irrene.easymusic.bean;

public class Position {
	private float x;
	private float y;

	public static Position make(float x,float y){
		return new Position(x, y);
	}
	
	public Position(float x,float y){
		this.x = x;
		this.y = y;
	}
	
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public void init(int x,int y){
		this.x = x;
		this.y = y;
	}
	
	public void dump(Position pos){
		this.x = pos.x;
		this.y = pos.y;
	}
}
