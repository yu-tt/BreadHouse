package com.example.shu;

import com.example.shu.manage.BreadHouse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EditActivity extends Activity {

	 private TextView editsalenum1=null;
	 private TextView editsalenum2=null;
	 private TextView editsalenum3=null;
	 private TextView editnownum1=null;
	 private TextView editnownum2=null;
	 private TextView editnownum3=null;
	 private TextView editgrade=null;
	 private Button edit2=null;
	 BreadHouse house=BreadHouse.getInstance();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit);
		
		 editsalenum1=(TextView)findViewById(R.id.editsalenum1);
		 editsalenum2=(TextView)findViewById(R.id.editsalenum2);
		 editsalenum3=(TextView)findViewById(R.id.editsalenum3);
		 editnownum1=(TextView)findViewById(R.id.editnownum1);
		 editnownum2=(TextView)findViewById(R.id.editnownum2);
		 editnownum3=(TextView)findViewById(R.id.editnownum3);
		 editgrade=(TextView)this.findViewById(R.id.editgrade);
		 edit2=(Button)findViewById(R.id.edit2);
	
        //获取intent对象存的数据，即CountActivity的数据传递过来（id:sale_id1->id:editsalenum1)
        StringBuffer s1=new StringBuffer();
        s1.append(getIntent().getStringExtra("sale_id1"));
        editsalenum1.setText(s1);
        
        StringBuffer s2=new StringBuffer();
        s2.append(getIntent().getStringExtra("sale_id2"));
        editsalenum2.setText(s2);
         
        StringBuffer s3=new StringBuffer();
        s3.append(getIntent().getStringExtra("sale_id3"));
        editsalenum3.setText(s3);
        
        StringBuffer s4=new StringBuffer();
        s4.append(getIntent().getStringExtra("num_id1"));
        editnownum1.setText(s4);
        
        StringBuffer s5=new StringBuffer();
        s5.append(getIntent().getStringExtra("num_id2"));
        editnownum2.setText(s5);
        
        StringBuffer s6=new StringBuffer();
        s6.append(getIntent().getStringExtra("num_id3"));
        editnownum3.setText(s6);
        
        StringBuffer s7=new StringBuffer();
        s7.append(getIntent().getStringExtra("grade_id"));
        editgrade.setText(s7);
        
        edit2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v){
				int cakenum=Integer.parseInt(editsalenum1.getText().toString());
				int pizzanum=Integer.parseInt(editsalenum2.getText().toString());
				int breadnum=Integer.parseInt(editsalenum3.getText().toString());
				
				house.setCakeSaleNum(cakenum);
				house.setPizzaSaleNum(pizzanum);
				house.setBreadSaleNum(breadnum);
				house.setGrade(cakenum,pizzanum,breadnum);	
				
				Intent intent=new Intent(EditActivity.this,CountActivity.class);
				startActivity(intent);
				finish();
			}
		});
	}
}
