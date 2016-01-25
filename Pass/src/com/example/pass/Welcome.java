package com.example.pass;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

public class Welcome extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.welcome_demo);
		new Handler().postDelayed(new Runnable()
		{
			
			@Override
			public void run()
			{
				Intent intent = new Intent(Welcome.this, DataDemo.class);
				startActivity(intent);
				
			}
		}, 700);

	}
}
