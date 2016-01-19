package com.example.shu.entities;

import java.util.Calendar;
import java.util.Date;
import com.example.shu.intefaces.*;



public class food implements displayTasteInterface{
	private String name;  //ʳ������
	private String kind;  //ʳ������
    private	Calendar dropTime=Calendar.getInstance();   //����ʱ��
	private int keepDays;   //��������
	private String taste; //ζ��
	private String id;

	
	//���캯��
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
	
	//�ж�ʳ���Ƿ���ڣ�falseû���ڣ�true���ڡ�
	public boolean isDrop(){
		Calendar nowTime = Calendar.getInstance(); 
		nowTime.setTime(new Date());
	    boolean isDrop=dropTime.compareTo(nowTime)<0;   //ǰ�����ڴ����1.
        return isDrop; 
	}
	
	//ʵ�ֽӿ�displayTaste����
	public String displayTaste(String nTaste){
		taste=nTaste;
		return taste;
	}
	
	
	
}
