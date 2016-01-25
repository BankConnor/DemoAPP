package com.example.valueanimationdemo;

import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.OutputStream;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
@SuppressLint("NewApi")
public class MainActivity extends Activity implements  AnimatorUpdateListener, AnimatorListener 
{
	private TextView tv;
	private Demo demo;
	private MyView myView;
	private ValueAnimator animator;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		myView = new MyView(MainActivity.this);
		setContentView(myView);		
		
		/*
		 * ���� �ɱ���� ������ʼֵ����ֵֹ
		 * ��Ϊ�ǿɱ�����������ǿɴ�����ֵ ��ϵͳ������ǰֵ�ı任
		 */
		ValueAnimator animator = ValueAnimator.ofInt(100,200);
		
		animator.setDuration(10000);

		animator.setStartDelay(100);//�����ӳ�
		
		animator.addUpdateListener(this);
		animator.start();
		animator.addListener(this);
		animator.end();//�������������ֱ�Ӵӵ�ǰ״̬��ת������״̬ ��������ֵ����ɶ�������ֵֹ
		
		animator.cancel();//����ȡ��
		
		
	}

	@Override
	public void onAnimationUpdate(ValueAnimator animation)
	{
		/*
		 * �任���� �任һ�θ÷����ͱ���Ӧһ�� �任������0.0-1.0
		 * ���ӱ任�ܵ�ʱ�䳤�ȵ�Ӱ��
		 */
		animation.getAnimatedValue();//��ȡ��ǰ�任���Ӽ�����ݴ������ʼֵ����ֵֹ�ĵ�ǰֵ
		animation.getAnimatedFraction();//��ȡ��ǰ�任���ӵ�ֵ
	}

	@Override
	public void onAnimationStart(Animator animation)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAnimationEnd(Animator animation)
	{
		//���������ص�
	}

	@Override
	public void onAnimationCancel(Animator animation)
	{
		//����ȡ���ص�
	}

	@Override
	public void onAnimationRepeat(Animator animation)
	{
		// TODO Auto-generated method stub
		
	}



	

}
