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
		dialog = new ProgressDialog(ProgressDemo.this);//�����������Ի���Ŀհ�ģ��
		dialog.setIcon(android.R.drawable.ic_menu_always_landscape_portrait);//����ͼ��
		dialog.setTitle(Html.fromHtml("<h1>��ʾ</t1>"));//���öԻ���ı���
		dialog.setMessage("�����ļ��У����Ժ�");//���öԻ��������
		dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);//���öԻ������ʽ ָ��Ϊȷ���Ի���
		dialog.setMax(100);//�������ֵ
		dialog.setProgress(20);//���õ�ǰ����ֵ ���������onStart()�������½���ֵ���޷��ڽ�������ʾ����
		dialog.onStart();//���µ�ǰ����ֵ��UI������ʾ

		dialog.show();//չʾ����
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
			builder.setTitle("����");
			builder.setIcon(android.R.drawable.ic_dialog_info);
			builder.setMessage("��ǰ���������� �Ƿ��˳�?");
			builder.setPositiveButton("�˳�", this);
			builder.setNegativeButton("���˳�", null);
			builder.show();
		}
	}
}
