package com.example.bitmapdemo;

import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Im;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity
{
	private Bitmap bit;
	private ImageView image;
	private Boolean isOk=false;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		image = (ImageView) findViewById(R.id.main_iv);
		new Thread(){
			public void run() 
			{
				int count=0;
				
				Options opts = new Options();
				opts.inPreferredConfig = Bitmap.Config.ARGB_8888;
				bit = BitmapFactory.decodeFile("/mnt/sdcard/foot.jpg", opts);
				Matrix m = new Matrix();
				m.setScale(5f, 5f);
				bit = bit.createBitmap(bit, 0, 0, bit.getWidth(), bit.getHeight(), m, true);
				OutputStream stream=null;
					try
					{
						stream = openFileOutput("Connor.jpg", MODE_PRIVATE);
						bit.compress(Bitmap.CompressFormat.JPEG, 100, stream);
						//isOk = true;
						while(count<=20)
						{
							++count;
							bit = BitmapFactory.decodeStream(openFileInput("Connor.jpg"));
							m.setScale(5f, 5f);
							bit = bit.createBitmap(bit, 0, 0, bit.getWidth(), bit.getHeight(), m, true);
							stream = openFileOutput("Connor.jpg", MODE_PRIVATE);
							bit.compress(CompressFormat.JPEG, 100, stream);
						}
						isOk = true;
					} catch (FileNotFoundException e)
					{
						e.printStackTrace();
					}

					
			}
		}.start();
		
		
	}
	
	public void draw(View v)
	{
		if(isOk)
		{
			Toast.makeText(getApplicationContext(), "Ok", Toast.LENGTH_LONG).show();
		}
		else
		{
			Toast.makeText(getApplicationContext(), "╪сть", Toast.LENGTH_LONG).show();
		}
	}
}
