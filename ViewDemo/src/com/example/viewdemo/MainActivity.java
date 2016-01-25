package com.example.viewdemo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener
{
	private ImageView image;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		//image.setOnClickListener(l);
		super.onCreate(savedInstanceState);
		MyView myView = new MyView(MainActivity.this);
		//setContentView(R.layout.activity_main);
		setContentView(myView);
		myView.setOnClickListener(this);
	}
	@Override
	public void onClick(View v)
	{
		Toast.makeText(getApplicationContext(), "µã»÷", Toast.LENGTH_LONG).show();
	}


}
