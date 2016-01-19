package com.example.shu;

import com.example.shu.manage.BreadHouse;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CountActivity extends Activity {
		private Button edit1= null;
		private TextView sale_id1=null; 
		private TextView sale_id2=null;
		private TextView sale_id3=null;
		private TextView num_id1=null;
		private TextView num_id2=null;
		private TextView num_id3=null;
		private TextView grade_id=null;
		BreadHouse house=BreadHouse.getInstance();

	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.count);
	        
          edit1=(Button)findViewById(R.id.edit1);
    	  sale_id1=(TextView)findViewById(R.id.sale_id1); 
    	  sale_id2=(TextView)findViewById(R.id.sale_id2);
    	  sale_id3=(TextView)findViewById(R.id.sale_id3);
    	  num_id1=(TextView)findViewById(R.id.num_id1);
    	  num_id2=(TextView)findViewById(R.id.num_id2);
    	  num_id3=(TextView)findViewById(R.id.num_id3);
    	  grade_id=(TextView)findViewById(R.id.grade_id);
       
		   sale_id1.setText(String.valueOf(house.getCakeSaleNum()));
		   sale_id2.setText(String.valueOf(house.getPizzaSaleNum()));  
		   sale_id3.setText(String.valueOf(house.getBreadSaleNum()));
		   num_id1.setText(String.valueOf(house.currentCakeNum()));
		   num_id2.setText(String.valueOf(house.currentPizzaNum()));
		   num_id3.setText(String.valueOf(house.currentBreadNum()));
		   grade_id.setText(String.valueOf(house.getGrade()));
	       
			 //设置按钮的单击事件
			 edit1.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						
						Intent intent=new Intent();
						intent.setClass(CountActivity.this, EditActivity.class);
						
						intent.putExtra("sale_id1",sale_id1.getText());
						intent.putExtra("sale_id2",sale_id2.getText());
						intent.putExtra("sale_id3",sale_id3.getText());
						intent.putExtra("num_id1",num_id1.getText());
						intent.putExtra("num_id2",num_id2.getText());
						intent.putExtra("num_id3",num_id3.getText());
						intent.putExtra("grade_id",grade_id.getText());
						startActivity(intent); 
						finish();
					}
				});
	}
	    
	    protected void onDestroy(){
			super.onDestroy();
			SharedPreferences countsp=getSharedPreferences("all",CountActivity.MODE_PRIVATE);
	    	Editor editor = countsp.edit();
	    	editor.putInt("csalenum", house.getCakeSaleNum());
	    	editor.putInt("psalenum", house.getBreadSaleNum());
	    	editor.putInt("bsalenum", house.getBreadSaleNum());
	    	editor.commit();
		}
}
