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
		Intent intent = new Intent("Connor");//ָ��������Ϣ
		intent.putExtra("Data", "Foot");//Я������
		sendBroadcast(intent);//���͹㲥
	}

}
