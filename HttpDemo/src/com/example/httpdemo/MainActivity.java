package com.example.httpdemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.provider.Settings;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Service;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity
{
	private Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) 
		{
			
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void sendhttp(View v) throws Exception
	{
		if(this.isConnected())
		{
			ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
			NetworkInfo info = connectivityManager.getActiveNetworkInfo();
			//当前网络设备可用
			Toast.makeText(getApplicationContext(),info.getTypeName(), Toast.LENGTH_LONG).show();
		}
		else
		{
			AlertDialog.Builder set = new Builder(this);
			set.setIcon(android.R.drawable.ic_delete);
			set.setTitle("警告！");
			set.setMessage("当前未连接到网络，请去设置在进行尝试");
			set.setPositiveButton("设置", new OnClickListener()
			{
				
				@Override
				public void onClick(DialogInterface dialog, int which)
				{
					Intent intent = new Intent(Settings.ACTION_SETTINGS);
					MainActivity.this.startActivity(intent);
					MainActivity.this.finish();
				}
			});
			set.show();
		}
	}
	
	private Boolean isConnected()
	{
		/*
		 * ConnectivityManager网络设备管理者
		 * 专门用来管理网络设备的
		 */
		ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
		NetworkInfo info = connectivityManager.getActiveNetworkInfo();
		if(info == null)
		{
			/*
			 * 当前网络设备不可用 
			 * 设备故障或者在飞行模式中
			 */
			return false;
		}
		else
		{
			/*
			 * 当前网络设备可用
			 * 但是不知道是否连入网络
			 * info.isConnectedOrConnecting();//当前设备已连入网络或者正在连入访问 但是不能保证连入成功
			 */
			return info.isConnected();//判断当前设备是否连入网络 true 连入网络， false 没有连入
		}
	}

}
