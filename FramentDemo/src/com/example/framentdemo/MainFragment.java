package com.example.framentdemo;

import android.R;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainFragment extends Fragment
{
	@Override
	public void onAttach(Activity activity)
	{
		/*
		 * 准备状态
		 * 告知Activity,当前的Fragment与Activity关联起来
		 * 可以获取到当前与之关联的Fragment对象
		 */
		super.onAttach(activity);
		Log.i("Connor", "Fragment - onAttach");
		Log.e("Connor", getClass()+"");
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		Log.i("Connor", "Fragment - onCreate");
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		/*
		 * 参数1：inflater The LayoutInflater object that can be used to inflate
		 * any views in the fragment, 布局容器加载器
		 * 参数2：当前Fragment所附着UI界面的ViewGroup对象
		 * 参数3：被系统销毁的时候保存的状态到这个Bundle对象里可以获取到
		 * 返回Fragment所附着的视图对象
		 */
		return inflater.inflate(R);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
	}
	
	@Override
	public void onStart()
	{
		// TODO Auto-generated method stub
		super.onStart();
		Log.i("Connor", "Fragment - onStart");
	}
	
	@Override
	public void onResume()
	{
		super.onResume();
		Log.i("Connor", "Fragment - onResume");
	}
	
	@Override
	public void onPause()
	{
		super.onPause();
		Log.i("Connor", "Fragment - onPause");
	}
	
	@Override
	public void onStop()
	{
		// TODO Auto-generated method stub
		super.onStop();
		Log.i("Connor", "Fragment - onStop");
	}
	
	@Override
	public void onDestroyView()
	{
		super.onDestroyView();
		
	}
	
	@Override
	public void onDestroy()
	{
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.i("Connor", "Fragment - onDestory");
		
	}
	
	@Override
	public void onDetach()
	{
		super.onDetach();
	}
	
}
