package com.example.localbroadcast;

import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity
{
	private LocalBroadcastManager local;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		local = local.getInstance(this);
		
		local.registerReceiver(new BroadcastReceiver()
		{
			
			@Override
			public void onReceive(Context context, Intent intent)
			{
				Toast.makeText(context, "���ع㲥", Toast.LENGTH_LONG).show();
			}
		}, new IntentFilter("Connor"));//ֻ�������Ա�����Connor������Ϣ
	}
	
	public void sendBro(View v)
	{
		local.sendBroadcast(new Intent("Connor"));//���ͱ��� ����ͷ��Connor
	}

}
