package com.example.shu.manage;

import java.util.*;
import com.example.shu.entities.*;


public class BreadHouse extends  Observable {
	
	

	private int cakeSaleNum;   //销售量
	private int pizzaSaleNum;  
	private int breadSaleNum;  
	private int grade;    //绩效
	
	public  LinkedList<Cake> cakeList =new LinkedList<Cake>();
	public LinkedList<Pizza> pizzaList =new LinkedList<Pizza>();
	public LinkedList<Bread> breadList =new LinkedList<Bread>();
	
	//单例模式主体。
	private volatile static BreadHouse uniqueInstance;
	private BreadHouse(){};
	public static BreadHouse getInstance() { //静态方法
        if (uniqueInstance == null){   //检查实例，不存在则进入同步区
        	synchronized(BreadHouse.class){
        		if (uniqueInstance == null){ //进入同步区后，在检查实例，不存在则创建实例
        			 uniqueInstance = new BreadHouse();
        		}
        	}
        }
        return uniqueInstance;
    }
	
	
	//统计
	public int getCakeSaleNum(){return cakeSaleNum;}
	public int getPizzaSaleNum(){return pizzaSaleNum;}
	public int getBreadSaleNum(){return breadSaleNum;}
	public int getGrade(){return grade;}
	
	public int currentCakeNum(){
		return cakeList.size();
	}
	
	public int currentPizzaNum(){
		return pizzaList.size();
	}
	
	public int currentBreadNum(){
		return breadList.size();
	}
	
	//编辑
	public void setCakeSaleNum(int newNum){cakeSaleNum=newNum;}
	public void setPizzaSaleNum(int newNum){pizzaSaleNum=newNum;}
	public void setBreadSaleNum(int newNum){breadSaleNum=newNum;}
	public void setGrade(int cnum,int pnum,int bnum){
		grade=cnum*4+pnum*3+bnum*2;
		this.setChanged();
		this.notifyObservers(this.grade);
		}
	
   
	//生产FOOD
	public void productCake(Cake currentProductCake){
			((LinkedList<Cake>) cakeList).addFirst(currentProductCake);
		}
	public void productCake(String name,String kind,int size,String id){
			Cake currentProductCake=new Cake(name,kind,3,id,true, size);
			cakeList.add(currentProductCake);
		}
		
	public void productPizza(Pizza currentProductPizza){
			pizzaList.add(currentProductPizza);
		}
		
    public void productPizza(String name,String kind,int size,String id){
			Pizza currentProductPizza=new Pizza(name,kind,1,id,"纸盒",size);
			pizzaList.add(currentProductPizza);
		}
		
	public void productBread(Bread currentProductBread){
			breadList.add(currentProductBread);
		}
		
	public void productBread(String name,String kind,String id){
			Bread currentProductBread=new Bread(name,kind,7,id,false);
			breadList.add(currentProductBread);
		}
		
		//卖FOOD
	
	public void saleCake(Cake currentSaleCake){
			cakeList.remove(currentSaleCake);
			cakeSaleNum+=1;
			grade+=4;
			this.setChanged();
			this.notifyObservers(this.grade);
			}
	public void saleCake(String id){
		for (int i=0;i<cakeList.size();i++)
		{
			Cake a=(Cake) cakeList.get(i);
			if(a.getId().equals(id)){
				cakeList.remove(i);
				break;
				}		
		}
		cakeSaleNum+=1;
		grade+=4;
		this.setChanged();
		this.notifyObservers(this.grade);
		}
	
	public void saleCake(int n){
		cakeList.remove(n);
		cakeSaleNum+=1;
		grade+=4;
		this.setChanged();
		this.notifyObservers(this.grade);
		}
		
	public void salePizza(Pizza currentSalePizza){
			pizzaList.remove(currentSalePizza);
			pizzaSaleNum+=1;
			grade+=3;
			this.setChanged();
			this.notifyObservers(this.grade);
			}
	
	public void salePizza(String id){
		for (int i=0;i<pizzaList.size();i++)
		{
			Pizza a=(Pizza) pizzaList.get(i);
			if(a.getId().equals(id)){pizzaList.remove(i);break;}		
		}
		pizzaSaleNum+=1;
		grade+=3;
		this.setChanged();
		this.notifyObservers(this.grade);
		}
		
	public void saleBread(Bread currentSaleBread){
			breadList.remove(currentSaleBread);
			breadSaleNum+=1;
			grade+=2;
			this.setChanged();
			this.notifyObservers(this.grade);
			}
	

	public void saleBread(String id){
		for (int i=0;i<breadList.size();i++)
		{
			Bread a=(Bread) breadList.get(i);
			if(a.getId().equals(id)){
				breadList.remove(i);
			    break;
			}		
		}
		breadSaleNum+=1;
		grade+=2;
		this.setChanged();
		this.notifyObservers(this.grade);
		}
	
	//过期作废蛋糕,可以设置定时遍历 
	public String[] dropCake(){
		String id[]=null;
		for (int i=0;i<cakeList.size();i++)
		{
			Cake a=(Cake) cakeList.get(0);
			if(a.isDrop()){
				id[i]=a.getId();
				cakeList.remove(0);
				}
			else
				break;	
		}
		return id;
		/*Iterator it=cakeList.iterator();
		Cake a=(Cake) it.next();
		while(it.hasNext()){
			if(a.isDrop()){it.remove();}
			else
				break;
		}*/
		
	}
	
	public String[] dropPizza(){
		String id[] = null;
		for (int i=0;i<pizzaList.size();i++)
		{
			Pizza a=(Pizza) pizzaList.get(0);
			if(a.isDrop()){
				id[i]=a.getId();
				pizzaList.remove(0);}
			else
				break;	
		}
		return id;
		/*
		Iterator it=pizzaList.iterator();
		Pizza a=(Pizza)it.next();
		while(it.hasNext()){
			if(a.isDrop()){it.remove();}
			else
				break;
		}*/
	}
	
	public String[] dropBread(){
		
		String id[]=null;
		for (int i=0;i<breadList.size();i++)
		{
			Bread a=(Bread) breadList.get(0);
			if(a.isDrop()){
				id[i]=a.getId();
				breadList.remove(0);}
			else
				break;	
		}
		return id;
		/*
		Iterator it=breadList.iterator();
		Bread a=(Bread)it.next();
		while(it.hasNext()){
			if(a.isDrop()){it.remove();}
			else
				break;
		}*/
	}
	
	public void dropAll(){
		cakeList.removeAll(cakeList);
		breadList.removeAll(breadList);
		pizzaList.removeAll(pizzaList);
		 
	}
	
		
}
