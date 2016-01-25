package com.example.wifidemo;

import android.os.Bundle;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TextView tv = (TextView) findViewById(R.id.main_tv);
		WifiManager manager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
		List<WifiConfiguration> list = manager.getConfiguredNetworks();
		for (WifiConfiguration wifiConfiguration : list)
		{
			tv.append(wifiConfiguration.toString());
		}
	}

}
