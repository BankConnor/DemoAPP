package com.example.pass;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.ImageView;

public class AlterDemo extends Activity implements OnClickListener 
{
	private String message="";
	private String items[]=new String[4];
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.ratingbar_demo);
		ImageView view = new ImageView(this);
		view.setImageResource(R.drawable.a);
		AlertDialog.Builder builder = new Builder(this);//�װ�
		/*
		 * ���öԻ������ʽ����Ӧ����
		 */
		builder.setIcon(R.drawable.ic_launcher);
		builder.setView(view);
		
		builder.create().show();
		
	}

	@Override
	public void onClick(DialogInterface dialog, int which)
	{
		Log.i("Connor", "��ѡ���ְҵ�ǣ�"+items[which]);
	}

}
