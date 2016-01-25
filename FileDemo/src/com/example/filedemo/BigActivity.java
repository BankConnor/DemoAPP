package com.example.filedemo;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class BigActivity extends Activity
{
	private ImageView image;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bigact_image);
		
		intoViews();
	}
	private void intoViews()
	{
		String filepath = getIntent().getStringExtra("image");
		image = (ImageView) findViewById(R.id.bigact_image);
		image.setImageURI(Uri.parse("file:///"+filepath));
	}
}	
