package com.example.progressbarbroadcast;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service
{

	@Override
	public IBinder onBind(Intent intent)
	{
		return null;
	}
	
	@Override
	public void onStart(Intent intent, int startId)
	{
		super.onStart(intent, startId);
		new Thread(){
			public void run() {
				int count=0;
				while(true)
				{
					if(count>=100)
					{
						break;
					}
					try
					{
						Thread.sleep(500);
					} catch (InterruptedException e)
					{
						e.printStackTrace();
					}
					++count;
					Intent intent = new Intent("PROGRESSBAR");
					intent.putExtra("Data", count);
					sendBroadcast(intent);
				}
			}
		}.start();
	}

}
