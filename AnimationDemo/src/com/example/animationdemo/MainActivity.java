package com.example.animationdemo;

import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.Window;

import java.io.FileNotFoundException;
import java.io.OutputStream;

import android.R.bool;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity 
{
	
	private MyView my;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		my = (MyView) findViewById(R.id.mainMyview);
		
		Options options = new Options();
		options.inPreferredConfig = Config.ARGB_8888;
		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.a,options);
		try
		{
			OutputStream outputStream = openFileOutput("A.jpg", MODE_PRIVATE);
			bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void show(View v)
	{
		my.setText("Hello Android");
		my.getLayoutParams().height=100;
		
		my.requestLayout();
	}
	
	
	


	

}
