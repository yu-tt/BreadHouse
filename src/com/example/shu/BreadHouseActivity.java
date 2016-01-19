package com.example.shu;

import com.example.shu.entities.Bread;
import com.example.shu.entities.Cake;
import com.example.shu.entities.Pizza;
import com.example.shu.manage.BreadHouse;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class BreadHouseActivity extends Activity {
	
	private Button b1=null;
	private Button b2=null;
	private Button b3=null;
	private Button b4=null;
	BreadHouse house=BreadHouse.getInstance();
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.breadhouse); 
        
        SharedPreferences sp=getSharedPreferences("all",BreadHouseActivity.MODE_PRIVATE);
        
        int cs=sp.getInt("cs",0);//如果没有key值，默认为0
        int ps=sp.getInt("ps",0);//如果没有key值，默认为0
        int bs=sp.getInt("bs",0);//如果没有key值，默认为0
        
        house.setCakeSaleNum(sp.getInt("csalenum",0));
        house.setPizzaSaleNum(sp.getInt("psalenum",0));
        house.setBreadSaleNum(sp.getInt("bsalenum",0));
        house.setGrade(sp.getInt("csalenum",0), sp.getInt("psalenum",0), sp.getInt("bsalenum",0));
        		 		 
        for(int i=0;i<cs;i++) {  
        	String name=sp.getString("cname"+i, "");
            String kind=sp.getString("ckind"+i, "");
            String id=sp.getString("cid"+i, "");
            int size=sp.getInt("csize"+i, 0);
            Cake currentProductCake=new Cake(name,kind,3,id,true, size);
            house.cakeList.add(currentProductCake);	
          }  
        for(int i=0;i<ps;i++) {  
        	String name=sp.getString("pname"+i, "");
            String kind=sp.getString("pkind"+i, "");
            String id=sp.getString("pid"+i, "");
            int size=sp.getInt("psize"+i, 0);
            Pizza currentProductPizza=new Pizza(name,kind,1,id,"纸盒",size);
            house.pizzaList.add(currentProductPizza);	
          }  
        for(int i=0;i<bs;i++) {  
        	String name=sp.getString("bname"+i, "");
            String kind=sp.getString("bkind"+i, "");
            String id=sp.getString("bid"+i, "");
            Bread currentProductBread=new Bread(name,kind,7,id,false);
			house.breadList.add(currentProductBread);
          }  
        
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        b4=(Button)findViewById(R.id.b4);
        
        OnClickListener li = new View.OnClickListener() 
        {
			@Override
			
			public void onClick(View v) {
				Intent intent=null;
				switch(v.getId()){
					case R.id.b1:
						intent=new Intent("make");
						intent.addCategory("makefood");
						startActivity(intent);	
						break;
					case R.id.b2:
						intent=new Intent("sale");
						intent.addCategory("salefood");
						startActivity(intent);	
						break;
					case R.id.b3:
						intent=new Intent(BreadHouseActivity.this,DropActivity.class);
						startActivity(intent);	
						break;
					case R.id.b4:
						intent=new Intent(BreadHouseActivity.this,CountActivity.class);
						startActivity(intent);	
						break;
				}
			}
		};
		
        b1.setOnClickListener(li);
        b2.setOnClickListener(li);
        b3.setOnClickListener(li);
        b4.setOnClickListener(li);   
    }
    
}