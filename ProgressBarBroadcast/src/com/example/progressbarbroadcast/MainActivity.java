package com.example.progressbarbroadcast;

import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.Menu;
import android.widget.ProgressBar;

public class MainActivity extends Activity
{
	private ProgressBar pro;
	private final int PROGRESSBAR_MAX=100;
	private BroadcastReceiver bro = new BroadcastReceiver()
	{
		
		@Override
		public void onReceive(Context context, Intent intent)
		{
			int count = intent.getIntExtra("Data", 0);
			pro.setProgress(count);
			if(count==100)
			{
				MainActivity.this.stopService(new Intent(MainActivity.this, MyService.class));
				unregisterReceiver(bro);
			}
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		intoViews();
		//���Ĺ㲥
		IntentFilter filter = new IntentFilter("PROGRESSBAR");
		registerReceiver(bro, filter);//ע�����
		//��������
		startService(new Intent(this, MyService.class));
	}

	private void intoViews()
	{
		pro = (ProgressBar) findViewById(R.id.main_pro);
		pro.setMax(PROGRESSBAR_MAX);//�������ֵ
	}


}
