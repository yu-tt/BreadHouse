package com.example.shu.view;

import java.util.Observable;
import java.util.Observer;
import android.util.Log;


public class bank implements Observer {

	@Override
	public void update(Observable observable, Object data) {
		//System.out.println("Ŀǰ��Ч�ǣ�"+data);
		Log.e("yttProResult=============","��ǰ��ЧΪ��"+data);	
		}

	}
