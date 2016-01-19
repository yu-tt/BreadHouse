package com.example.shu;

import com.example.shu.manage.BreadHouse;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DropActivity extends Activity {
	
	private Button b1= null;
	private Button b2= null;
	private TextView t1=null; 
	private TextView t2=null; 
	private TextView t3=null; 
	
	BreadHouse house =BreadHouse.getInstance();
	@Override
	public void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
		 setContentView(R.layout.drop);
		 
		 b1=(Button)findViewById(R.id.b1);
		 b2=(Button)findViewById(R.id.b2);
		 t1=(TextView)findViewById(R.id.t1);
		 t2=(TextView)findViewById(R.id.t2);
		 t3=(TextView)findViewById(R.id.t3);
		 
		 b2.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {	
				house.dropAll();
				Toast.makeText(getApplicationContext(), house.currentCakeNum()+"+"+house.currentBreadNum()+"+"+house.currentPizzaNum(), Toast.LENGTH_LONG).show();
			}
			 
		 });
		 
		 b1.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {	
					//house.dropCake();
					//house.dropPizza();
					
					String cid[]=house.dropCake();
					if(cid!=null){
						int clen=cid.length;
						String st="";
						for(int i=0;i<clen;i++){
							if(i==0){
								st=st+"过期蛋糕ID："+cid[i]+",";
							}
							if(i==clen-1){st=st+cid[i];}
							else
								st=st+cid[i]+",";
						}
						t1.setText(st);	
					}
					else
						{t1.setText("没有蛋糕过期！");}		
				
					
				String pid[]=house.dropPizza();
				if(pid!=null){
					int plen=pid.length;
					String st="";
					for(int i=0;i<plen;i++){
						if(i==0){
							st=st+"过期蛋糕ID："+pid[i]+",";
						}
						if(i==plen-1){st=st+pid[i];}
						else
							st=st+pid[i]+",";
					}
					t3.setText(st);	
				}
				else
					{t3.setText("没有披萨过期！");}	
					
					
					String bid[]=house.dropBread();
					if(bid!=null){
						int blen=bid.length;
						String st="";
						for(int i=0;i<blen;i++){
							if(i==0){
								st=st+"过期面包ID："+bid[i]+",";
							}
							if(i==blen-1){st=st+bid[i];}
							else
								st=st+bid[i]+",";
						}
						t2.setText(st);	
					}
					else
						t2.setText("没有面包过期！");		
				 
				}});
		 }
}

