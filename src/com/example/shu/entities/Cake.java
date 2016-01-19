package com.example.shu.entities;
import com.example.shu.intefaces.addFruitInterface;

public class Cake extends food implements addFruitInterface{
	private boolean putFridge; //是否放冰箱保存
	private int size;  //
	private String fruit;//加的水果
	
	public Cake(){};
	public Cake(String name,String kind,int keepDays,String id,boolean putFridge,int size){
		super(name,kind,keepDays,id);
		this.putFridge=putFridge;
		this.size=size;
	}
	
	public void setPutFridge(boolean newPutbrige){putFridge=newPutbrige;}
	public boolean getPutFridge(){return putFridge;}
	public void setSize(int newSize){size=newSize;}
	public int getSize(){return size;}
	public void setFruit(String newFruit){fruit=newFruit;}
	public String getFruit(){return fruit;}
	
	//实现接口addFruit方法
	public boolean addFruit(String newfruit){
		fruit=newfruit;
		return true;
		}

}
