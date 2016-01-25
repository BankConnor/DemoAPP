package com.example.sendbro;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void sendBro(View v)
	{
		Intent intent = new Intent("Connor");//指定订阅消息
		intent.putExtra("Data", "Foot");//携带数据
		sendBroadcast(intent);//发送广播
	}

}
