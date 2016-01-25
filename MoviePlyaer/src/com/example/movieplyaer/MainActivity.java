package com.example.movieplyaer;

import android.os.Bundle;
import android.provider.MediaStore.Audio.Media;

import java.io.IOException;

import android.app.Activity;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends Activity
{
	private VideoView videoView;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initViews();
	}

	private void initViews()
	{
		MediaPlayer mediaPlayer = new MediaPlayer();
		try
		{
			mediaPlayer.setDataSource("/mnt/sdcard/test.mp4");
			mediaPlayer.prepare();
			mediaPlayer.start();
		} catch (IllegalArgumentException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void player(View v)
	{
		videoView.start();
	}
	
	public void pause(View v)
	{
		videoView.pause();
	}
	
	public void stop(View v)
	{
		//videoView.stopPlayback();
	}
	

}
