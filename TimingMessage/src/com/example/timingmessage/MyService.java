package com.example.timingmessage;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service
{
	private MainActivity activity;
	private MyBinder myBinder ;
	
	@Override
	public void onCreate()
	{
		super.onCreate();
		myBinder = new MyBinder();
	}
	
	@Override
	public IBinder onBind(Intent intent)
	{
		//把this对象包装进去返回
		return myBinder;
	}
	
	public void timingmessage(final int time)
	{
		new Thread(){
			public void run() {
				int count = 0;
				while(count<=time)
				{
					try
					{
						Thread.sleep(1000);
					} catch (InterruptedException e)
					{
						e.printStackTrace();
					}
					++count;
				}
			}
		}.start();
		activity.setTimeingMessage();//时间到通知活动
	}
	
	class MyBinder extends Binder
	{
		public MyService getService()
		{
			return MyService.this;
		}
	}

	public void binderActivity(MainActivity mainActivity)
	{
		activity = mainActivity;
	}
	
	@Override
	public boolean onUnbind(Intent intent)
	{
		return super.onUnbind(intent);
	}
	
	@Override
	public void onDestroy()
	{
		super.onDestroy();
	}
}
