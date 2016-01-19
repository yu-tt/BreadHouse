package com.example.shu.entities;

import java.util.Calendar;
import java.util.Date;
import com.example.shu.intefaces.*;



public class food implements displayTasteInterface{
	private String name;  //食物名称
	private String kind;  //食物种类
    private	Calendar dropTime=Calendar.getInstance();   //生产时间
	private int keepDays;   //保质天数
	private String taste; //味道
	private String id;

	
	//构造函数
	public food(){};
	public food(String newName,String newKind,int newKeepDays,String newid){
			name=newName;
			kind=newKind;
			keepDays=newKeepDays;
			id=newid;
			dropTime.setTime(new Date());
			dropTime.add(Calendar.DATE, keepDays);  
			}

	public void setName(String newName){name=newName;}
	public String getName(){return name;}
	
	public void setKind(String newKind){kind=newKind;}
	public String getKind(){return kind;}
	
	public void setKeepDays(int newKeepDays){keepDays=newKeepDays;}
	public int getKeepDays(){return keepDays;}
	
	public Calendar getDropTime(){return dropTime;}
	
	public void setId(String newid){id=newid;}
	public String getId(){return id;}
	
	//判断食物是否过期，false没过期，true过期。
	public boolean isDrop(){
		Calendar nowTime = Calendar.getInstance(); 
		nowTime.setTime(new Date());
	    boolean isDrop=dropTime.compareTo(nowTime)<0;   //前者日期大，输出1.
        return isDrop; 
	}
	
	//实现接口displayTaste方法
	public String displayTaste(String nTaste){
		taste=nTaste;
		return taste;
	}
	
	
	
}
