package com.example.datasxml;

import android.os.Bundle;
import android.os.IBinder;

import org.apache.http.HttpHost;
import org.apache.http.client.methods.HttpPost;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity implements ServiceConnection
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void sendData(View v)
	{
		bindService(new Intent(), this, 0);
		SharedPreferences preferences = getPreferences(MODE_PRIVATE);
		Editor editor = preferences.edit();
		editor.putString("name", "gxx");
		editor.commit();
	}

	@Override
	public void onServiceConnected(ComponentName name, IBinder service)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onServiceDisconnected(ComponentName name)
	{
		// TODO Auto-generated method stub
		
	}

}
