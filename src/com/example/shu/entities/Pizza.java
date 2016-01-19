package com.example.shu.entities;

public class Pizza extends food {
	private String box;    //°ü×°ºÐ
	private int size;      //³ß´ç
	
	public Pizza(){};
	public Pizza(String name,String kind,int keepDays,String id,String box,int size){
		super(name,kind,keepDays,id);
		this.box=box;
		this.size=size;
	}
	
	public void setBox(String newBox){box=newBox;}
	public String getBox(){return box;}
	public void setSize(int newSize){size=newSize;}
	public int getSize(){return size;}
}