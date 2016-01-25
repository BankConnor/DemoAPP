package com.example.receiverbro;

import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.Menu;

public class MainActivity extends Activity
{
	
	private BroadcastReceiver bro = new BroadcastReceiver()
	{
		
		@Override
		public void onReceive(Context context, Intent intent)
		{
			this.abortBroadcast();
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		IntentFilter filter  = new IntentFilter();
		filter.setPriority(100);//设置优先级 优先级最高者可以优先获取到广播信息	
		filter.addAction("Connor");//设置接受的广播动作
		registerReceiver(bro, filter);
		
		Intent intent = new Intent();
		
		sendOrderedBroadcast(intent, null);

	}

}
