package com.example.listviewtest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.example.listviewtest.R.layout;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

public class PlayerMovie extends Activity
{
	private VideoView video;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.player_moview);
		
		try
		{
			intoViews();
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void intoViews() throws Exception
	{
		video = (VideoView) findViewById(R.id.player_movie_video);
		InputStream inputStream = this.getAssets().open("troyesivan.mp4");
		OutputStream outputStream = new FileOutputStream(new File("/mnt/sdcard/movie/troyesivan.mp4"));
		int len=0;
		byte[] buff = new byte[1024*1024];
		
		while((len=inputStream.read(buff))!=-1)
		{
			outputStream.write(buff, 0, len);
		}
		
		inputStream.close();
		outputStream.close();
		
		video.setVideoURI(Uri.parse("file:////mnt/sdcard/movie/troyesivan.mp4"));
		video.start();
	}
}
