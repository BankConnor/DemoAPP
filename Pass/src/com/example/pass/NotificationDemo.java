package com.example.pass;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NotificationDemo extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.demo3_re);
		NotificationManager notification = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		notification.cancelAll();
	}
	
	
}
