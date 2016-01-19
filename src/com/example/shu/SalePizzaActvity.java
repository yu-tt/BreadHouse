package com.example.shu;

import com.example.shu.manage.BreadHouse;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class SalePizzaActvity extends Activity {

	private Button b1= null;
	private TextView e1=null; 
	BreadHouse house=BreadHouse.getInstance();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.salepizza);
		
		b1=(Button)findViewById(R.id.b1);
	    e1=(TextView)findViewById(R.id.e1); 
	    
	    b1.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				String id=e1.getText().toString();
				house.salePizza(id);
				e1.setText("");
				Toast.makeText(getApplicationContext(), String.valueOf(house.getPizzaSaleNum()), Toast.LENGTH_LONG).show();
			}
	    	
	    });
		
	}
}