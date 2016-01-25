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
		media = new MediaPlayer();//����״̬
		try
		{
			media.setDataSource("/mnt/sdcard/Bank.mp3");//��ʼ��״̬
			media.prepare();//׼��״̬
			media.setOnCompletionListener(this);//������ϵļ���
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
			//��ǰ��Media��ֹ̬ͣ
			try
			{
				media.prepare();//�ָ���׼��̬
			} catch (Exception e)
			{
				e.printStackTrace();
			} 
		}
		media.start();//����̬
	}
	
	public void pause(View v)
	{
		media.pause();//��̬ͣ
	}
	
	public void stop(View v)
	{
		media.stop();//ֹ̬ͣ
		isStopend = true;
	}

	@Override
	public void onCompletion(MediaPlayer mp)
	{
		//ϵͳ�ص�
		Toast.makeText(getApplicationContext(), "�������", Toast.LENGTH_LONG).show();
		mp.setLooping(true);//����ѭ������
	}
	
	

}
