package com.example.filedemo;

import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.net.Uri;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.DialerFilter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener
{
	private List<File> photo = new ArrayList<File>();//����Դ
	private ListView listview;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//׼������ �ݹ����SD���µ��������� �ж�ĩβ����jpg.png,jpeg��β�ĺ�׺�ļ�
		intoData();
		//��ʼ������ListView
		intoViews();
	}

	private void intoViews()
	{
		listview = (ListView) findViewById(R.id.main_photo_listview);
		MyAdapter adapter = new MyAdapter(photo, MainActivity.this);
		listview.setAdapter(adapter);
		listview.setOnItemClickListener(this);
	}

	private void intoData()
	{
		listFiles(Environment.getExternalStorageDirectory());
	}
	
	//�ݹ�ָ��·���������µ������ļ����ļ���
	private void listFiles(File filepath)
	{
		if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)||Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED_READ_ONLY))
		{
			if(filepath!=null)
			{
				File[] listfiles = filepath.listFiles();
				if(listfiles!=null)
				{
					for (int i = 0; i < listfiles.length; i++)
					{
						if(listfiles[i].isDirectory())
						{
							//�ļ���
							listFiles(listfiles[i]);
						}
						//�ļ� 
						String filename = listfiles[i].getName();
						if(filename.endsWith(".mp3"))
						{
							Log.i("Connor", filename);
							photo.add(listfiles[i]);
						}
					}
				}
			}
		}
		else
		{
			
			Toast.makeText(this, "����SD��", Toast.LENGTH_LONG).show();
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id)
	{
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_VIEW);
		intent.setDataAndType(Uri.parse("file://"+photo.get(position).getAbsolutePath()), "audio/mp3");
		startActivity(intent);
	}
	
	
	
	

}
