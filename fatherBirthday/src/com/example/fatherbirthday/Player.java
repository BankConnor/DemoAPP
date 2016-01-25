package com.example.fatherbirthday;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Player extends Activity implements OnClickListener, OnCompletionListener
{
	private MediaPlayer player;
	private InputStream in;
	private OutputStream out;
	private ImageView mp3image;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.player_music);
		intoViews();
	}
	

	private void intoViews()
	{
		 
		try
		{
			//生日快乐的录音
			out = new FileOutputStream(new File("/mnt/sdcard/happybirthday.3ga"));
			in = this.getAssets().open("happybirthday.3ga");//生日快乐的录音
			
			byte[] buff = new byte[1024*1024];
			int len=0;
			
			while((len=in.read(buff))!=-1)
			{
				out.write(buff, 0, len);
			}
			in.close();
			out.close();
			
		} catch (IOException e)
		{
			throw new RuntimeException("流读取错误", e);
		}

		player = new MediaPlayer();
		try
		{
			//指定播放生日快乐录音
			player.setDataSource(this,Uri.parse("file:///mnt/sdcard/happybirthday.3ga"));
			player.prepare();
		}
		catch(Exception e)
		{
			Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
			
			Log.i("Connor", e.getMessage());
			throw new RuntimeException("播放初始化失败", e); 
		}
		player.setOnCompletionListener(this);
		mp3image = (ImageView)findViewById(R.id.mp3);
		mp3image.setOnClickListener(this);	
	}



	@Override
	public void onClick(View v)
	{	 
		
		if(player.isPlaying())
		{
			mp3image.setImageResource(R.drawable.playermp3);
			player.pause();
			return;
		}
		if(!player.isPlaying())
		{
			player.start();	
			mp3image.setImageResource(R.drawable.stop);
			return;
		}
	}


	@Override
	public void onCompletion(MediaPlayer mp)
	{
		Intent intent = new Intent(this, BirthdayActivity.class);
		startActivity(intent);
		finish();
	}	
}
