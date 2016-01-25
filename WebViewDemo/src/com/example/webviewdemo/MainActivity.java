package com.example.webviewdemo;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.view.Menu;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends Activity
{
	private WebView web;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		intoViews();
	}

	private void intoViews()
	{
		web = (WebView) findViewById(R.id.main_web);
		/*
		 * 如果不指定WebViewClient WebView将会询问 Activity Manager 来选择合适操作者来操作该URL
		 */
		web.setWebViewClient(new WebViewClient(){
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url)
			{
				/*
				 * 参数1：本机应用的WebView控件
				 * 参数2：url地址
				 */
				view.loadUrl(url);
				return true;//返回false代表由Activity Manager来选择合适者操作该URL
			}
			
			//页面开始加载
			@Override
			public void onPageStarted(WebView view, String url, Bitmap favicon)
			{
				/*
				 * 参数1：加载该URL的WebView控件
				 * 参数2：加载的URL
				 * 参数3：位图
				 */
				Toast.makeText(getApplicationContext(), "当前加载URL"+url, Toast.LENGTH_LONG).show();
			}
			
			//页面结束加载
			@Override
			public void onPageFinished(WebView view, String url)
			{
				/*
				 * 参数1：加载该URL的WebView控件
				 * 参数2：加载的URL
				 */
				super.onPageFinished(view, url);
			}
		});
		
		web.getSettings().setJavaScriptEnabled(true);//支持JavaScript
		web.getSettings().setBuiltInZoomControls(true);//支持手势缩放
	
		web.reload();//刷新
		
		/*
		 * 判断是否可以前进
		 * true 前进 false 不可前进
		 */
		web.canGoForward();
		web.goForward();//前进
		
		web.loadUrl("http://192.168.1.100:8080/");//加载URL,如果不指定WebViewClient将由Activity Manager来指定操作者(浏览器)
	}
	
}
