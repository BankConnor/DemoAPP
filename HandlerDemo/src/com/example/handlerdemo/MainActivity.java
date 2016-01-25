package com.example.handlerdemo;

import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.provider.SyncStateContract.Helpers;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import android.app.Activity;
import android.app.ProgressDialog;

public class MainActivity extends Activity
{
	private File filepath;
	private File file;
	private final int UPDATE_INT=0;
	private ProgressDialog proDialog;
	private final int HELP_ERRO=1;
	private Handler handle = new Handler()
			{
				public void handleMessage(Message msg) 
				{
					switch (msg.what)
					{
					case UPDATE_INT:
						long T = file.length();
						int p = (int) ((100*msg.arg1)/T);
						proDialog.setProgress(p);
						proDialog.onStart();
						if(p>=100)
						{
							proDialog.dismiss();//消失掉
						}
						break;
					case HELP_ERRO:
						Toast.makeText(getApplicationContext(), "无法写人到SD卡上", Toast.LENGTH_LONG).show();
					}
				}
			};

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initViews();
		initDate();
	}

	private void initDate()
	{
		if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()))
		{
			file = new File(Environment.getExternalStorageDirectory().getAbsoluteFile()+"/happy.mp3");
		}
	}

	private void initViews()
	{
		proDialog = new ProgressDialog(MainActivity.this);
	}
	
	public void updateFile(View v)
	{
		proDialog.setIcon(android.R.drawable.ic_menu_close_clear_cancel);
		proDialog.setMessage("下载进行中....");
		proDialog.setMax(100);
		proDialog.setProgress(0);
		proDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		proDialog.show();
		new Thread(){
			public void run() {
				if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()))
				{
					filepath = new File(Environment.getExternalStorageDirectory().getAbsoluteFile()+"/hello.mp3");
					try
					{
						OutputStream outputStream = new FileOutputStream(filepath);
						InputStream inputStream = new FileInputStream(file);
						
						byte[] buff = new byte[1024*1024];
						int len=0;
						int count=0;
					
						while((len=inputStream.read(buff))!=-1)
						{
							count = len+count;
							Message message = Message.obtain();
							message.what = UPDATE_INT;
							message.arg1 = count;
							outputStream.write(buff, 0, len);
							handle.sendMessage(message);
							Log.i("Connor", "Out");
						}
					} catch (Exception e)
					{
						throw new RuntimeException(e);
					}
				}
				else
				{
					handle.sendEmptyMessage(HELP_ERRO);
				}
			}
		}.start();
	}

}
