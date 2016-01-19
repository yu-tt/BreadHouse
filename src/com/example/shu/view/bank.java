package com.example.shu.view;

import java.util.Observable;
import java.util.Observer;
import android.util.Log;


public class bank implements Observer {

	@Override
	public void update(Observable observable, Object data) {
		//System.out.println("目前绩效是："+data);
		Log.e("yttProResult=============","当前绩效为："+data);	
		}

	}
