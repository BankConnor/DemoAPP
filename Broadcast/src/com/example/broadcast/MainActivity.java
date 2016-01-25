package com.example.broadcast;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity
{
	private EditText editText;
	private String time;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		intoViews();
		new Thread(){
			
			public void run() {
				BroadcastReceiver bro = new BroadcastReceiver()
				{
					
					@Override
					public void onReceive(Context context, Intent intent)
					{
						
						
					}
				};
				registerReceiver(bro, new IntentFilter("TimingMessage"));//注册广播
			}
		}.start();
		
	}
	private void intoViews()
	{
		editText = (EditText) findViewById(R.id.main_et);
	}
	
	public void settingTime(View v)
	{
		time = editText.getText().toString();
		editText.setText("");
		Intent intent = new Intent(this,MyService.class);
		int time = Integer.valueOf(this.time);
		intent.putExtra("Data", time);
		startService(intent);//启动服务
	}

}
