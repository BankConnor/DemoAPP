package com.example.pass;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class Demo extends Activity implements OnSeekBarChangeListener 
{
	private TextView textView;
	private ProgressBar probar;
	private SeekBar seekbar;
	private int width;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ratingbar_demo);
		
		intoViews();
	}

	private void intoViews()
	{
		probar = (ProgressBar)findViewById(R.id.rat_probar);
		seekbar = (SeekBar)findViewById(R.id.rat_seekbar);
		probar.setBackgroundResource(R.drawable.b);
		textView = (TextView)findViewById(R.id.rat_tv);
		seekbar.setOnSeekBarChangeListener(this);
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		width = metrics.widthPixels;
	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
	{
		probar.setProgress(progress);
		
		textView.setText(((progress/width)*100)+"%");
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar)
	{
		probar.setMax(width);
		seekbar.setMax(width);
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar)
	{
		
	}
	
}
