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
		 * 参数 可变参数 传入起始值和终止值
		 * 因为是可变参数，所以是可传入多个值 由系统决定当前值的变换
		 */
		ValueAnimator animator = ValueAnimator.ofInt(100,200);
		
		animator.setDuration(10000);

		animator.setStartDelay(100);//设置延迟
		
		animator.addUpdateListener(this);
		animator.start();
		animator.addListener(this);
		animator.end();//立马结束动画且直接从当前状态跳转到结束状态 并把属性值分配成动画的终止值
		
		animator.cancel();//动画取消
		
		
	}

	@Override
	public void onAnimationUpdate(ValueAnimator animation)
	{
		/*
		 * 变换因子 变换一次该方法就被响应一次 变换因子由0.0-1.0
		 * 因子变换受到时间长度的影响
		 */
		animation.getAnimatedValue();//获取当前变换因子计算根据传入的起始值和终止值的当前值
		animation.getAnimatedFraction();//获取当前变换因子的值
	}

	@Override
	public void onAnimationStart(Animator animation)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAnimationEnd(Animator animation)
	{
		//动画结束回调
	}

	@Override
	public void onAnimationCancel(Animator animation)
	{
		//动画取消回调
	}

	@Override
	public void onAnimationRepeat(Animator animation)
	{
		// TODO Auto-generated method stub
		
	}



	

}
