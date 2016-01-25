package com.example.receiverbro;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Receiver extends BroadcastReceiver
{

	//广播接收器 专门用来接受广播
	@Override
	public void onReceive(Context context, Intent intent)
	{
		Intent activityContext = new Intent(context, MainActivity.class);
		context.startActivity(activityContext);
	}

}
