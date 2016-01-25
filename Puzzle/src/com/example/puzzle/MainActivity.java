package com.example.puzzle;

import android.os.Bundle;
import android.util.Log;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import com.MyViewGroup.MyRelativeLayout;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity
{

	private MyRelativeLayout mRelativeLayout;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mRelativeLayout = (MyRelativeLayout) findViewById(R.id.main_viewgroup);
	}

	public void demo(View v)
	{
		int count = mRelativeLayout.getChildCount();
		int num[] = randomCommon(0, mRelativeLayout.getN()*mRelativeLayout.getN()-1, mRelativeLayout.getN()*mRelativeLayout.getN());
		for (int i = 0; i < count; i++)
		{
			ImageView imageView = (ImageView) mRelativeLayout.getChildAt(i);
			imageView.setImageBitmap(mRelativeLayout.getBitmap().get(num[i]));
			imageView.setTag(num[i]);
		}
	}
	
	public  int[] randomCommon(int min, int max, int n){  
		  int len = max-min+1;  
	      
		    if(max < min || n > len){  
		        return null;  
		    }  
		      
		    //初始化给定范围的待选数组  
		    int[] source = new int[len];  
		       for (int i = min; i < min+len; i++){  
		        source[i-min] = i;  
		       }  
		         
		       int[] result = new int[n];  
		       Random rd = new Random();  
		       int index = 0;  
		       for (int i = 0; i < result.length; i++) {  
		        //待选数组0到(len-2)随机一个下标  
		           index = Math.abs(rd.nextInt() % len--);  
		           //将随机到的数放入结果集  
		           result[i] = source[index];  
		           //将待选数组中被随机到的数，用待选数组(len-1)下标对应的数替换  
		           source[index] = source[len];  
		       }  
		       return result;  
	} 
}
