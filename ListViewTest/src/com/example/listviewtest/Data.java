package com.example.listviewtest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.util.Log;

public class Data
{
	public static int imageicon[] ={R.drawable.ue404, R.drawable.ue405,R.drawable.ue406,R.drawable.ue407,
			R.drawable.ue408,R.drawable.ue409,R.drawable.ue410,R.drawable.ue411,
			R.drawable.ue412,R.drawable.ue413,R.drawable.ue414,R.drawable.ue415,R.drawable.ue404}; 
	public static int imageBig[] = {R.drawable.u1,R.drawable.u2,R.drawable.u3,R.drawable.u4,R.drawable.u5,R.drawable.u6,R.drawable.u7,R.drawable.u8,
			R.drawable.u9,R.drawable.u10,R.drawable.u11,R.drawable.yoyo,R.drawable.u20};
	public static String message[] = {"»ð³µ","ºþ±ß","º£±ß","½Ö±ß","ÌúÂ·","»¨Ìï","²ÝÔ°","»ð","¾¨Óã","ÂäÈÕ","ÈºÉ½","Bank","Connor"};
	
	public static List<Datamessage> data = new ArrayList<Data.Datamessage>();
	
	public static void intoData()
	{
		for (int i = 0; i < imageicon.length; i++)
		{
			Datamessage datamessage = new Datamessage();
			datamessage.icon = imageicon[i];
			datamessage.message = message[i];
			data.add(datamessage);
		}
	}
	
	static class Datamessage
	{
		public int icon;
		public String message;
	}
	
}
