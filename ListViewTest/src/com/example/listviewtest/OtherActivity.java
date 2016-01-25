package com.example.listviewtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class OtherActivity extends Activity
{
	private ImageView image;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.imgaebig);
		intoViews();
	}

	private void intoViews()
	{
		Intent intent = getIntent();
		int id = intent.getIntExtra("id", 0);
		image = (ImageView) findViewById(R.id.other_image);
		image.setImageResource(Data.imageBig[id]);
	}
}
