package com.example.contextactivitysizedemo;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void showData(View v)
	{
		View decroView = getWindow().getDecorView();
		FrameLayout contentView = (FrameLayout) decroView.findViewById(Window.ID_ANDROID_CONTENT);
		ViewGroup group = (ViewGroup) contentView.getParent();//获取到ContentView的父容器
		View title = group.getChildAt(0);
		
		int discroViewHeight = getResources().getDisplayMetrics().heightPixels;//屏幕的高度
		int viewGroupHeight = contentView.getHeight()+title.getHeight();//标题栏和内容的高度
		Log.i("Connor", "状态栏的高度"+(discroViewHeight-viewGroupHeight));
		
	}
	
	public int px2dp(float density, int dp)
	{
		/*
		 * 参数1 当前用户的屏幕的像素密度
		 * 参数2 dp值 
		 */
		return (int)(density/dp+0.5);
	}

}
