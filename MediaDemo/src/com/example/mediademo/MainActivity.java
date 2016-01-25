package com.example.mediademo;

import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.MediaStore.Images.Media;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.view.Menu;
import android.widget.ImageView;

public class MainActivity extends Activity
{

	private ImageView image;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		image = (ImageView) findViewById(R.id.main_image);
		Intent intent = new Intent();
		intent.setType("image/*");
		startActivity(intent);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		/*
		 * 返回拍照的照片
		 */
		if(requestCode==1)
		{
		
			Uri uri = data.getData();
			if(uri==null)
			{
				/*
				 * 如果是低版本Android系统将是返回null
				 */
				Bundle bundle = data.getExtras();//低版本把数据封装到Bundle中 意味照片数据并不是很大 Bundle有限
				Bitmap bit = (Bitmap) bundle.get("data");
				image.setImageBitmap(bit);
				return;
			}
			//高版本
			try
			{
				Bitmap bit = Media.getBitmap(getContentResolver(), uri);
				image.setImageBitmap(bit);
				OutputStream out = openFileOutput("Connor.txt", MODE_PRIVATE);
				out.write(uri.toString().getBytes());
			} catch (Exception e)
			{
				throw new RuntimeException(e);
			}
		}	
	}
}


