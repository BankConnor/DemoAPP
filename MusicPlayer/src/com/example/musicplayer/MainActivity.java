package com.example.musicplayer;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore.Audio.Media;
import android.util.Log;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity implements  OnItemClickListener, OnSeekBarChangeListener, OnCompletionListener
{
	private boolean flags=true;
	private boolean isStop;
	private static final int ON_STAT_TIME=5;
	private static final int ON_START=4;
	private static final int OK_DATA=3;
	private MyAdapter adapter;
	private ProgressDialog dialog;
	private static final int DIS_PRO=2;
	private static final int SHOW_PRO=1;
	private List<Music> musics;
	private ListView listView;
	private SeekBar seek;
	private TextView startTime;
	private TextView endTime;
	private MediaPlayer media = new MediaPlayer();
	private SimpleDateFormat format = new SimpleDateFormat("mm:ss");
	private Date date = new Date();
	private int pos;
	private Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg)
		{
			if(msg.what==DIS_PRO)
			{
				dialog.dismiss();
			}
			else if(msg.what==SHOW_PRO)
			{
				showPro();
			}
			else if(msg.what==OK_DATA)
			{
				adapter = new MyAdapter(MainActivity.this, musics);
				listView.setAdapter(adapter);
				listView.setOnItemClickListener(MainActivity.this);
				dialog.dismiss();
			}
			else if(msg.what==ON_START)
			{
				int value = msg.arg1;
				seek.setProgress(value);
			}
			else if(msg.what==ON_STAT_TIME)
			{
				int value = msg.arg1;
				date.setTime(value);
				startTime.setText(format.format(date));
			}
		}
	};
	
	private void showPro()
	{
		dialog = new ProgressDialog(MainActivity.this);
		dialog.setMessage("Lodaing");
		dialog.show();
	}
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initViews();
		initDatas();
		initLinster();
	}

	private void initLinster()
	{
		//监听进度 
		new Thread(){
			public void run() 
			{
				while(flags)
				{
					if(media.isPlaying())
					{	
						synchronized (MainActivity.this)
						{
							/*
							 * 避免活动退出时候子线程也还在运行
							 */
							int value = media.getCurrentPosition();//当前播放位置
						
							Message message = Message.obtain();
							message.what = ON_START;
							message.arg1 =value;
							if((value%2)==0)
							{
								Log.i("Connor", value+"");
								Message mes = Message.obtain();
								mes.what = ON_STAT_TIME;
								mes.arg1 =value;
								handler.sendMessage(mes);
							}
							handler.sendMessage(message);
						}
					}
				}
			}
		}.start();
		
		
	}
	private void initDatas()
	{
		new Thread(){
			public void run() 
			{
				ContentResolver resolver = getContentResolver();
				Cursor cursor = resolver.query(Media.EXTERNAL_CONTENT_URI, new String[]{Media._ID,Media.TITLE,Media.DURATION,Media.DATA,Media.ARTIST}, null, null, null);
				musics = new ArrayList<Music>();
				while(cursor.moveToNext())
				{
					musics.add(new Music(cursor.getString(cursor.getColumnIndex(Media.ARTIST)), cursor.getInt(cursor.getColumnIndex(Media._ID)), cursor.getString(cursor.getColumnIndex(Media.TITLE)), cursor.getLong(cursor.getColumnIndex(Media.DURATION)),cursor.getString(cursor.getColumnIndex(Media.DATA))));
				}
				//数据源准备完毕
				handler.sendEmptyMessage(OK_DATA);
			}
		}.start();
	}

	private void initViews()
	{
		showPro();
		listView = (ListView) findViewById(R.id.main_listview);
		seek = (SeekBar) findViewById(R.id.main_seek);
		startTime = (TextView) findViewById(R.id.main_startTime);
		endTime = (TextView) findViewById(R.id.main_endTime);
		seek.setOnSeekBarChangeListener(this);
		media.setOnCompletionListener(MainActivity.this);
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
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id)
	{
		media.reset();
		try
		{
			pos = position;
			media.setDataSource(musics.get(position).getData());
			media.prepare();
			
			int time = media.getDuration();//当前播放音乐的总时间
			
			date.setTime(time);
			endTime.setText(format.format(date));
			seek.setMax(media.getDuration());
			media.start();
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}
	
	
	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		synchronized (MainActivity.this)
		{
			//并且使用同步机制锁 防止退出的时候因为还在发Handler机制,导致获取不到数据而抛异常
			flags=false;//把子线程关掉，否则Hnadler还在获取MediaPlayer的进度值 但是当前的MediaPlayer是null
			media.reset();
			media.release();//释放资源
		}
	}
	@Override
	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
	{
		if(fromUser)
		{
			//跳转到指定的播放位置
			media.seekTo(progress);
			Message mes = Message.obtain();
			mes.what = ON_STAT_TIME;
			mes.arg1 =progress;
			handler.sendMessage(mes);
		}
	}
	@Override
	public void onStartTrackingTouch(SeekBar seekBar)
	{
		
	}
	@Override
	public void onStopTrackingTouch(SeekBar seekBar)
	{
		
	}
	@Override
	public void onCompletion(MediaPlayer mp)
	{
		try
		{
			if(pos<(musics.size()-1))
			{
				mp.reset();
				mp.setDataSource(musics.get(pos+1).getData());
				mp.prepare();
				mp.start();
			}
			else
			{
				mp.reset();
				mp.setDataSource(musics.get(0).getData());
				mp.prepare();
				mp.start();
			}
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		} 
	}
	

	
	
}
