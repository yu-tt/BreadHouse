package com.example.shu.entities;

public class Bread extends food {
	private boolean putFridge; //ÊÇ·ñ·Å±ùÏä±£´æ
	
	public Bread(){};
	public Bread(String name,String kind,int keepDays,String id,boolean putFridge){
		super(name,kind,keepDays,id);
		this.putFridge=putFridge;
	}
	
	public void setPutFridge(boolean newPutbrige){putFridge=newPutbrige;}
	public boolean getPutFridge(){return putFridge;}

}
