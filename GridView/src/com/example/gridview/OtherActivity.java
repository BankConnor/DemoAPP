package com.example.gridview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

public class OtherActivity extends Activity
{
	private ImageView imageview;
	private int image[] = {R.drawable.t01,R.drawable.t02,R.drawable.t03,
			R.drawable.t04,R.drawable.t05,R.drawable.t06,R.drawable.t07,R.drawable.t08,
			R.drawable.t09,R.drawable.u8,R.drawable.u9,R.drawable.yoyo,R.drawable.xk};
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image_big);
		
		intoViews();
	}

	private void intoViews()
	{
		imageview = (ImageView) findViewById(R.id.image_big_image);
		imageview.setImageResource(image[getIntent().getIntExtra("icon", 0)]);
	}
}
