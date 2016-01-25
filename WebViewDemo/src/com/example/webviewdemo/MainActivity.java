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
		 * �����ָ��WebViewClient WebView����ѯ�� Activity Manager ��ѡ����ʲ�������������URL
		 */
		web.setWebViewClient(new WebViewClient(){
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url)
			{
				/*
				 * ����1������Ӧ�õ�WebView�ؼ�
				 * ����2��url��ַ
				 */
				view.loadUrl(url);
				return true;//����false������Activity Manager��ѡ������߲�����URL
			}
			
			//ҳ�濪ʼ����
			@Override
			public void onPageStarted(WebView view, String url, Bitmap favicon)
			{
				/*
				 * ����1�����ظ�URL��WebView�ؼ�
				 * ����2�����ص�URL
				 * ����3��λͼ
				 */
				Toast.makeText(getApplicationContext(), "��ǰ����URL"+url, Toast.LENGTH_LONG).show();
			}
			
			//ҳ���������
			@Override
			public void onPageFinished(WebView view, String url)
			{
				/*
				 * ����1�����ظ�URL��WebView�ؼ�
				 * ����2�����ص�URL
				 */
				super.onPageFinished(view, url);
			}
		});
		
		web.getSettings().setJavaScriptEnabled(true);//֧��JavaScript
		web.getSettings().setBuiltInZoomControls(true);//֧����������
	
		web.reload();//ˢ��
		
		/*
		 * �ж��Ƿ����ǰ��
		 * true ǰ�� false ����ǰ��
		 */
		web.canGoForward();
		web.goForward();//ǰ��
		
		web.loadUrl("http://192.168.1.100:8080/");//����URL,�����ָ��WebViewClient����Activity Manager��ָ��������(�����)
	}
	
}
