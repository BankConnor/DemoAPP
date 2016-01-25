package com.example.pass;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.Toast;

public class ProgressDemo extends Activity implements OnClickListener, OnDismissListener
{
	private ProgressDialog dialog;
	private static int count=1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.demo3_re);
		
		initViews();
	}

	private void initViews()
	{
		dialog = new ProgressDialog(ProgressDemo.this);//创建进度条对话框的空白模板
		dialog.setIcon(android.R.drawable.ic_menu_always_landscape_portrait);//设置图标
		dialog.setTitle(Html.fromHtml("<h1>提示</t1>"));//设置对话框的标题
		dialog.setMessage("下载文件中，请稍后");//设置对话框的内容
		dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);//设置对话框的样式 指定为确定对话框
		dialog.setMax(100);//设置最大值
		dialog.setProgress(20);//设置当前进度值 如果不调用onStart()方法更新进度值将无法在界面上显示出来
		dialog.onStart();//更新当前进度值在UI界面显示

		dialog.show();//展示起来
	}

	@Override
	public void onClick(DialogInterface dialog, int which)
	{
		this.dialog.dismiss();
	}

	@Override
	public void onDismiss(DialogInterface dialog)
	{
		if(this.dialog.getProgress()<this.dialog.getMax())
		{
			AlertDialog.Builder builder = new Builder(ProgressDemo.this);
			builder.setTitle("警告");
			builder.setIcon(android.R.drawable.ic_dialog_info);
			builder.setMessage("当前任务还在下载 是否退出?");
			builder.setPositiveButton("退出", this);
			builder.setNegativeButton("不退出", null);
			builder.show();
		}
	}
}
