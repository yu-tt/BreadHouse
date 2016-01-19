package com.example.shu;

import com.example.shu.manage.BreadHouse;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MakePizzaActivity extends Activity {
	private Button b1= null;
	private TextView e1=null; 
	private TextView e2=null;
	private TextView e3=null;
	private TextView e4=null; 
	BreadHouse house=BreadHouse.getInstance();
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.makepizza);
		b1=(Button)findViewById(R.id.b1);
	    e1=(TextView)findViewById(R.id.e1); 
	    e2=(TextView)findViewById(R.id.e2); 
	    e3=(TextView)findViewById(R.id.e3); 
	    e4=(TextView)findViewById(R.id.e4); 
	    final LayoutInflater inflater = LayoutInflater.from(this);
		final LinearLayout lin = (LinearLayout) findViewById(R.id.linear3);
		
		 
	  
	    int cs=house.currentPizzaNum();
	    for(int i=0;i<cs;i++) {  
	        final RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.pizza, null);
	        TextView t1=(TextView)layout.findViewById(R.id.pizzaid);
			TextView t2=(TextView)layout.findViewById(R.id.pizzaname);
			TextView t3=(TextView)layout.findViewById(R.id.pizzakind);
		    TextView t4=(TextView)layout.findViewById(R.id.pizzasize);
		    Button b3=(Button)layout.findViewById(R.id.sale); 	
		     
	    	String name=house.pizzaList.get(i).getName();
			String kind=house.pizzaList.get(i).getKind();
			final String id=house.pizzaList.get(i).getId();
			int size=house.pizzaList.get(i).getSize();
			t1.setText("ID: "+id);
			t2.setText("Name: "+name);
			t3.setText("Kind: "+kind);
			t4.setText("Size: "+size+" ´ç");
			lin.addView(layout);
			b3.setOnClickListener(new View.OnClickListener(){
					@Override
					public void onClick(View v) {
						house.salePizza(id);
						lin.removeView(layout);
						}
				 });
	    }		
	    
	    b1.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				String name=e1.getText().toString();
				String kind=e2.getText().toString();
				final String id=e4.getText().toString();
				int size=Integer.parseInt(e3.getText().toString());
				house.productPizza(name, kind, size, id);
				
				//¶¯Ì¬ÔöÉ¾¿Ø¼þ
				final RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.pizza, null);
			     TextView t1=(TextView)layout.findViewById(R.id.pizzaid);
				 TextView t2=(TextView)layout.findViewById(R.id.pizzaname);
				 TextView t3=(TextView)layout.findViewById(R.id.pizzakind);
				 TextView t4=(TextView)layout.findViewById(R.id.pizzasize);
				 Button b3=(Button)layout.findViewById(R.id.sale); 	
				 
			    t1.setText("ID: "+id);
				t2.setText("Name: "+name);
				t3.setText("Kind: "+kind);
				t4.setText("Size: "+size+" ´ç");
				lin.addView(layout);
				b3.setOnClickListener(new View.OnClickListener(){
					@Override
					public void onClick(View v) {
						house.salePizza(id);
						lin.removeView(layout);
						}
				 });					
				e1.setText("");
				e2.setText("");
				e3.setText("");
				e4.setText("");
			}
	    });
	}
	
	protected void onDestroy(){
		super.onDestroy();
		SharedPreferences psp=getSharedPreferences("all",MakePizzaActivity.MODE_PRIVATE);
    	Editor editor = psp.edit();
    	int size=house.pizzaList.size();
    	editor.putInt("ps", size);
    	editor.putInt("psalenum", house.getPizzaSaleNum());
    	
    	for(int i=0;i<size;i++){
    		editor.remove("pid"+i);
    		editor.remove("pname"+i);
    		editor.remove("pkind"+i);
    		editor.remove("psize"+i);
    		
    		editor.putString("pid"+i, house.pizzaList.get(i).getId());	
    		editor.putString("pname"+i, house.pizzaList.get(i).getName());	
    		editor.putString("pkind"+i, house.pizzaList.get(i).getKind());	
    		editor.putInt("psize"+i, house.pizzaList.get(i).getSize());		
    	}
    	editor.commit();
	}
}

