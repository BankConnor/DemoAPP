package com.example.pass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;



public  class TextDemo extends Activity  
{
	private ProgressBar bar;
	private int max;
	private int count;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.frame_demo);
		Log.i("Connor", "Text");
		intoViews();
	}

	private void intoViews()
	{
		bar = (ProgressBar)findViewById(R.id.frame_demo);

	}
	
	
	
	
	public void change(View v)
	{
		++count;
		Log.i("Connor", count+"");
		bar.setProgress(count);
	}

	


	

	
}
