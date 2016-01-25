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
		rec = new MediaRecorder();//����״̬
		rec.setAudioSource(AudioSource.MIC);//ʹ����˷��豸��ȡ����
		rec.setOutputFormat(OutputFormat.DEFAULT);//�����û��ֻ��Զ�ѡ����ʵ���Ƶ��ʽ
		rec.setAudioEncoder(AudioSource.DEFAULT);//�����û����ֻ��Զ�ѡ����ʵ��ֽڱ����ʽ
		rec.setOutputFile("/mnt/sdcard/connor.mp3");//����¼�������Ƶ�����λ��
		try
		{
			rec.prepare();//׼��̬
		} catch (Exception e)
		{
			Log.i("Connor", e.toString());
			throw new RuntimeException(e);
		} 
	
	}
	public void start(View v)
	{
		MediaRecorderSeeting();
		
		rec.start();//��ʼ¼��
	}
	
	public void stop(View v)
	{
		rec.stop();//¼�����
	}
	
	public void reset(View v)
	{
		rec.reset();//�ͷ� ¼��ȡ����
		
	}
	
	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		
		/*
		 * ����״̬ͼ����
		 * ����ת��ɿ���״̬
		 * ���ͷ���Դ
		 */
		rec.reset();
		rec.release();//���� �ͷ���Դ
	
	}
}
