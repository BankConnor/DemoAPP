package com.example.intentbaidu;

import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity 
{
	private MediaPlayer media = new MediaPlayer();
	private boolean isStop;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		try
		{
			media.setDataSource("/mnt/sdcard/Bank.mp3");
			media.prepare();
			media.start();
		} catch (IllegalArgumentException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void music_start(View v) throws IllegalStateException, IOException
	{
		if(isStop)
		{
			media.prepare();
		}
		media.start();
	}
	
	public void music_pause(View v)
	{
		if(media.isPlaying())
		{
			media.pause();
		}
	}
	
	public void music_stop(View v)
	{
		if(media.isPlaying())
		{
			media.stop();
			isStop=true;
		}
	}
	
}
