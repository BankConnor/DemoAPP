package com.example.httpdemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.provider.Settings;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Service;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity
{
	private Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) 
		{
			
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void sendhttp(View v) throws Exception
	{
		if(this.isConnected())
		{
			ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
			NetworkInfo info = connectivityManager.getActiveNetworkInfo();
			//��ǰ�����豸����
			Toast.makeText(getApplicationContext(),info.getTypeName(), Toast.LENGTH_LONG).show();
		}
		else
		{
			AlertDialog.Builder set = new Builder(this);
			set.setIcon(android.R.drawable.ic_delete);
			set.setTitle("���棡");
			set.setMessage("��ǰδ���ӵ����磬��ȥ�����ڽ��г���");
			set.setPositiveButton("����", new OnClickListener()
			{
				
				@Override
				public void onClick(DialogInterface dialog, int which)
				{
					Intent intent = new Intent(Settings.ACTION_SETTINGS);
					MainActivity.this.startActivity(intent);
					MainActivity.this.finish();
				}
			});
			set.show();
		}
	}
	
	private Boolean isConnected()
	{
		/*
		 * ConnectivityManager�����豸������
		 * ר���������������豸��
		 */
		ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
		NetworkInfo info = connectivityManager.getActiveNetworkInfo();
		if(info == null)
		{
			/*
			 * ��ǰ�����豸������ 
			 * �豸���ϻ����ڷ���ģʽ��
			 */
			return false;
		}
		else
		{
			/*
			 * ��ǰ�����豸����
			 * ���ǲ�֪���Ƿ���������
			 * info.isConnectedOrConnecting();//��ǰ�豸������������������������ ���ǲ��ܱ�֤����ɹ�
			 */
			return info.isConnected();//�жϵ�ǰ�豸�Ƿ��������� true �������磬 false û������
		}
	}

}
