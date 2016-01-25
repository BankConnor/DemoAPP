package com.example.animation;

import android.os.Bundle;
import android.util.Log;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends Activity implements AnimationListener
{
	private ImageView image;
	private ScaleAnimation scale;
	private View v;
	private AnimationSet animationSet;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	}
	
	public void ani(View v)
	{
		image.setAnimation(animationSet);
		
		animationSet.startNow();//立马启动一次动画
	}

	@Override
	public void onAnimationStart(Animation animation)
	{
		//动画开始时调用
		Log.i("Connor", "开始");
	}

	@Override
	public void onAnimationEnd(Animation animation)
	{
		Log.i("Connor", "结束");
		
	}

	@Override
	public void onAnimationRepeat(Animation animation)
	{
		Log.i("Connor", "重复");
	}
}
