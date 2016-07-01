package com.irene.easymusic.bean;

public class Size {

		private float width;
		private float height;

		public static Size make(float wdith,float height){
			return new Size(wdith, height);
		}
		
		public Size(float width,float height){
			this.width = width;
			this.height = height;
		}
		
		public float getWidth(){
			return width;
		}
		
		public float getHeight(){
			return height;
		}
		
		public void setWidth(int width){
			this.width = width;
		}
		
		public void setHeight(int height){
			this.height = height;
		}
		
		public void init(int width,int height){
			this.width = width;
			this.height = height;
		}
		
		public void dump(Size size){
			this.width = size.width;
			this.height = size.height;
		}

}
