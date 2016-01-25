package com.example.pass;

import java.util.ArrayList;

import android.app.Activity;

public class ActivityManage
{
	public static ArrayList<Activity>manage = new ArrayList<Activity>();
	
	public static void addActivity(Activity activity)
	{
		manage.add(activity);
	}
	
	public static void removeAll()
	{
		for (Activity activity : manage)
		{
			if(activity==null)
			{
				activity.finish();
			}
		}
	}
}
