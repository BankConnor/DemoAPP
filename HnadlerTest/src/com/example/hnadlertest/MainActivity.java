package com.example.hnadlertest;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity
{
	private Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void threadA(View v)
	{
		new Thread(){
			public void run() {
				Handler handler = new Handler(){
					public void handleMessage(android.os.Message msg) {
						Log.i("Connor", "Ω” ’µΩ£°");
					}
				};
				while(true)
				{}
			}
		}.start();
	}
	
	public void threadB(View v)
	{
		//handler.sendEmptyMessage(1);
	}

}
