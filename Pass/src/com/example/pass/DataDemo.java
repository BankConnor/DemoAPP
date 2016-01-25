package com.example.pass;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import android.app.Activity;

import android.os.Bundle;
import android.text.Html;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

public class DataDemo extends Activity 
{
	private OutputStream out;
	private OutputStreamWriter writer;
	private BufferedWriter buff;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.birthday_demo);
		try
		{
			intoViews();
		} catch (Exception e)
		{
			Toast.makeText(getApplicationContext(), "Á÷Ê§°Ü"+e, Toast.LENGTH_LONG).show();
		}
	}

	private void intoViews() throws Exception
	{
		out  = new FileOutputStream(new File("/mnt/extSdCard/Log.txt"));
		writer = new OutputStreamWriter(out);
		buff = new BufferedWriter(writer);
		fileselect(new File("/mnt/"));
	}
	
	public void fileselect(File filepath) throws Exception
	{
		if(filepath.exists())
		{
			if(filepath.isDirectory())
			{
				File[] files = filepath.listFiles();
				if(files!=null)
				{
					for (File file : files)
					{
						fileselect(file);
					}
				}
			}
			buff.write(filepath.toString());
			buff.newLine();
			buff.flush();
		}
	}


}
