package com.example.broadcast;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service
{

	@Override
	public IBinder onBind(Intent intent)
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onCreate()
	{
		super.onCreate();
	}
	
	@Override
	public void onStart(Intent intent, int startId)
	{
		super.onStart(intent, startId);
		final int usermessagetime = intent.getIntExtra("Data", 0);
		new Thread(){
			public void run() {
				int count=0;
				while(true)
				{
					try
					{
						Thread.sleep(1000);
					} catch (InterruptedException e)
					{
						e.printStackTrace();
					}
					++count;
					if(count==usermessagetime)
					{
						break;
					}
				}
				sendBroadcast(new Intent("TimingMessage"));
			};
		}.start();
	}

}
