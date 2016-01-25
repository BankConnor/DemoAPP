package com.example.timingmessage;

import android.os.Bundle;
import android.os.IBinder;
import android.text.Html;
import android.util.Log;

import java.io.Serializable;

import com.example.timingmessage.MyService.MyBinder;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity implements Serializable, ServiceConnection
{
	private EditText edit;
	private String time;
	private MyService myservice;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initViews();//��ʼ���ؼ�
		startBinService();//�󶨷���
	}

	private void startBinService()
	{
		Intent intent = new Intent(MainActivity.this, MyService.class);
		bindService(intent, MainActivity.this, BIND_AUTO_CREATE);//�󶨷���
	}

	private void initViews()
	{
		edit = (EditText) findViewById(R.id.main_et);
	}
	
	public void setting(View v)
	{
		myservice.binderActivity(this);
		time = edit.getText().toString();
		myservice.timingmessage(Integer.valueOf(time));
	}

	@Override
	public void onServiceConnected(ComponentName name, IBinder service)
	{
		//�������ܰ󶨳ɹ�����Ϣ
		MyBinder myBinder = (MyBinder)service;
		myservice = myBinder.getService();
	}

	@Override
	public void onServiceDisconnected(ComponentName name)
	{
		//���������֪ͨ������
	}
	
	public void setTimeingMessage()
	{
		AlertDialog.Builder builder = new Builder(MainActivity.this);
		builder.setMessage(Html.fromHtml("<font color='red'><h1>ʱ���ѵ���</h1></font>"));
		builder.create().show();
	}
	
	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		unbindService(this);
	}


}
