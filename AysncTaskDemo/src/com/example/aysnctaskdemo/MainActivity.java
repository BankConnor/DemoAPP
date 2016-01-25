package com.example.aysnctaskdemo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.app.Activity;
import android.app.ProgressDialog;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity
{
	private InputStream in;
	private OutputStream out;
	private ProgressDialog pro;
	private File startFile;
	private File endFile;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	

	public void updateUI(View v)
	{
		
		AsyncTask<File, Integer, Boolean> task = new AsyncTask<File, Integer, Boolean>()
		{
			@Override
			protected void onPreExecute()
			{
				pro = new ProgressDialog(MainActivity.this);
				pro.setIcon(android.R.drawable.ic_input_delete);
				pro.setMax(100);
				pro.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
				pro.setMessage("拷贝进行中...");
				pro.setTitle("拷贝文件");
				pro.show();
			}
			
			@Override
			protected Boolean doInBackground(File... params)
			{
				//拷贝文件路径获取
				startFile = params[0];
				endFile = params[1];
				
				//流的初始化和拷贝文件的准备
				try
				{
					in = new FileInputStream(startFile);
					out = new FileOutputStream(endFile);
					
					int len = 0;
					int count = 0;
					byte[] buff = new byte[1024*1024];
					
					while((len=in.read(buff))!=-1)
					{
						out.write(buff, 0, len);
						count = len+count;//叠加计算
						publishProgress(count);//开始准备更新UI界面
					}
				} catch (Exception e)
				{
					return false;
				}
				
				return true;
			}
			
			@Override
			protected void onProgressUpdate(Integer... values)
			{
				//UI界面的更新
				int count = values[0];
				int p = (int) ((100*count)/(startFile.length()));
				pro.setProgress(p);
				pro.onStart();
			}
			
			@Override
			protected void onPostExecute(Boolean result)
			{
				if(result)
				{
					try
					{
						in.close();
						out.close();
					} catch (IOException e)
					{
						
					}
					Toast.makeText(getApplicationContext(), "拷贝完成", Toast.LENGTH_LONG).show();
					pro.dismiss();
				}else
				{
					try
					{
						in.close();
						out.close();
					} catch (IOException e)
					{
						
					}
					Toast.makeText(getApplicationContext(), "拷贝失败", Toast.LENGTH_LONG).show();
					pro.dismiss();
				}
			}
		};
		
		if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
		{
			task.execute(new File(Environment.getExternalStorageDirectory().getAbsoluteFile()+"/hello.mp3"),new File(Environment.getExternalStorageDirectory().getAbsoluteFile()+"/Connor.mp3"));
		}
		else
		{
			Toast.makeText(getApplicationContext(), "SD卡不可用，请检查！！！", Toast.LENGTH_LONG).show();
		}
	}

}
