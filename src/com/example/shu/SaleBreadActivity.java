package com.example.shu;

import com.example.shu.manage.BreadHouse;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SaleBreadActivity extends Activity {

	private Button b1= null;
	private TextView e1=null; 
	BreadHouse house=BreadHouse.getInstance();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.salebread);
		
		Log.e("ytt---SaleBreadActivity",this.toString());
		
		b1=(Button)findViewById(R.id.b1);
	    e1=(TextView)findViewById(R.id.e1); 
	    
	    b1.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				String id=e1.getText().toString();
				house.saleBread(id);
				e1.setText("");
				Toast.makeText(getApplicationContext(), "面包销售量："+String.valueOf(house.getBreadSaleNum())+"面包当前数量："+String.valueOf(house.currentBreadNum()), Toast.LENGTH_LONG).show();
				
			}
	    	
	    });
	    
	    
		
	}
}