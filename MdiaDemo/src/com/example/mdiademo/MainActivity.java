package com.example.mdiademo;

import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

import android.app.Activity;
import android.media.MediaRecorder;
import android.media.MediaRecorder.AudioSource;
import android.media.MediaRecorder.OutputFormat;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity
{
	private MediaRecorder rec;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
	}
	
	private void MediaRecorderSeeting()
	{
		rec = new MediaRecorder();//空闲状态
		rec.setAudioSource(AudioSource.MIC);//使用麦克风设备获取声音
		rec.setOutputFormat(OutputFormat.DEFAULT);//根据用户手机自动选择合适的音频格式
		rec.setAudioEncoder(AudioSource.DEFAULT);//根据用户的手机自动选择合适的字节编码格式
		rec.setOutputFile("/mnt/sdcard/connor.mp3");//设置录制完毕音频保存的位置
		try
		{
			rec.prepare();//准备态
		} catch (Exception e)
		{
			Log.i("Connor", e.toString());
			throw new RuntimeException(e);
		} 
	
	}
	public void start(View v)
	{
		MediaRecorderSeeting();
		
		rec.start();//开始录制
	}
	
	public void stop(View v)
	{
		rec.stop();//录制完毕
	}
	
	public void reset(View v)
	{
		rec.reset();//释放 录制取消掉
		
	}
	
	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		
		/*
		 * 按照状态图流程
		 * 首先转变成空闲状态
		 * 在释放资源
		 */
		rec.reset();
		rec.release();//销毁 释放资源
	
	}
}
