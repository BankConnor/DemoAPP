package com.example.mediaplayerdemo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

import android.R;
import android.R.bool;
import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.view.Menu;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends Activity implements OnCompletionListener
{
	private MediaPlayer media;
	private ProgressBar bar;

	private boolean isStopend = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initViews();
	}

	private void initViews()
	{
		media = new MediaPlayer();//空闲状态
		try
		{
			media.setDataSource("/mnt/sdcard/Bank.mp3");//初始化状态
			media.prepare();//准备状态
			media.setOnCompletionListener(this);//播放完毕的监听
		} catch (Exception e)
		{
			Log.i("Connor", e+"");
			throw new RuntimeException(e);
		} 
	}
	
	public void start(View v)
	{
		if(isStopend)
		{
			//当前是Media是停止态
			try
			{
				media.prepare();//恢复到准备态
			} catch (Exception e)
			{
				e.printStackTrace();
			} 
		}
		media.start();//运行态
	}
	
	public void pause(View v)
	{
		media.pause();//暂停态
	}
	
	public void stop(View v)
	{
		media.stop();//停止态
		isStopend = true;
	}

	@Override
	public void onCompletion(MediaPlayer mp)
	{
		//系统回调
		Toast.makeText(getApplicationContext(), "播放完毕", Toast.LENGTH_LONG).show();
		mp.setLooping(true);//设置循环播放
	}
	
	

}
