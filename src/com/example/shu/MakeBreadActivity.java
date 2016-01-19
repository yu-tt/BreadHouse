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

public class MakeBreadActivity extends Activity {
	private Button b1= null;
	private TextView e1=null; 
	private TextView e2=null;
	private TextView e3=null;
	
	BreadHouse house=BreadHouse.getInstance();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.makebread);
		 
		b1=(Button)findViewById(R.id.b1);
	    e1=(TextView)findViewById(R.id.e1); 
	    e2=(TextView)findViewById(R.id.e2); 
	    e3=(TextView)findViewById(R.id.e3); 
	    final LayoutInflater inflater = LayoutInflater.from(this);
		final LinearLayout lin = (LinearLayout) findViewById(R.id.linear2);
	  
	    int cs=house.currentBreadNum();
	    for(int i=0;i<cs;i++) {  
	        final RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.bread, null);
	        TextView t1=(TextView)layout.findViewById(R.id.breadid);
			TextView t2=(TextView)layout.findViewById(R.id.breadname);
			TextView t3=(TextView)layout.findViewById(R.id.breadkind);
		    Button b3=(Button)layout.findViewById(R.id.sale); 	
		     
	    	String name=house.breadList.get(i).getName();
			String kind=house.breadList.get(i).getKind();
			final String id=house.breadList.get(i).getId();
	
			t1.setText("ID: "+id);
			t2.setText("Name: "+name);
			t3.setText("Kind: "+kind);
			lin.addView(layout);
			b3.setOnClickListener(new View.OnClickListener(){
					@Override
					public void onClick(View v) {
						house.saleBread(id);
						lin.removeView(layout);
						}
				 });
	    }		
	    
	    b1.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				String name=e1.getText().toString();
				String kind=e2.getText().toString();
				final String id=e3.getText().toString();
				house.productBread(name, kind, id);
				
				//¶¯Ì¬ÔöÉ¾¿Ø¼þ
				final RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.bread, null);
			     TextView t1=(TextView)layout.findViewById(R.id.breadid);
				 TextView t2=(TextView)layout.findViewById(R.id.breadname);
				 TextView t3=(TextView)layout.findViewById(R.id.breadkind);
				 Button b3=(Button)layout.findViewById(R.id.sale); 	
				 
			    t1.setText("ID: "+id);
				t2.setText("Name: "+name);
				t3.setText("Kind: "+kind);
				lin.addView(layout);
				b3.setOnClickListener(new View.OnClickListener(){
					@Override
					public void onClick(View v) {
						house.saleBread(id);
						lin.removeView(layout);
						}
				 });					
				e1.setText("");
				e2.setText("");
				e3.setText("");
			}
	    });
	}
	
	protected void onDestroy(){
		super.onDestroy();
		SharedPreferences bsp=getSharedPreferences("all",MakePizzaActivity.MODE_PRIVATE);
    	Editor editor = bsp.edit();
    	int size=house.breadList.size();
    	editor.putInt("bs", size);
    	editor.putInt("bsalenum", house.getBreadSaleNum());
    	
    	for(int i=0;i<size;i++){
    		editor.remove("bid"+i);
    		editor.remove("bname"+i);
    		editor.remove("bkind"+i);
    		
    		editor.putString("bid"+i, house.breadList.get(i).getId());	
    		editor.putString("bname"+i, house.breadList.get(i).getName());	
    		editor.putString("bkind"+i, house.breadList.get(i).getKind());		
    	}
    	editor.commit();
	}
}
