package com.example.fatherbirthday;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

public class BirthdayActivity extends Activity
{
	private MediaPlayer player;
	private InputStream in;
	private OutputStream out;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.birthday_demo);
		intoViews();
	}

	private void intoViews()
	{
		try
		{
			/*
			 * 写入生日快乐MP3
			 */
			out = new FileOutputStream(new File("/mnt/sdcard/Happy.mp3"));
			in = this.getAssets().open("happy.mp3");//打开资源文件assets文件
			
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
			/*
			 * 指定播放的是生日快乐MP3
			 */
			player.setDataSource(this, Uri.parse("file:///mnt/sdcard/Happy.mp3"));
			player.prepare();
			player.start();
			Toast toast = Toast.makeText(getApplicationContext(), null, Toast.LENGTH_LONG);
			ImageView imageView = new ImageView(BirthdayActivity.this);
			imageView.setImageResource(R.drawable.coke);
			toast.setView(imageView);//指定一张生日蛋糕的照片
			toast.show();
		}
		catch(Exception e)
		{
			Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
			throw new RuntimeException("播放初始化失败", e); 
		}
	}
	
}
