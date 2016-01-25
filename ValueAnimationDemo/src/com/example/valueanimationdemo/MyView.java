package com.example.valueanimationdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;
public class MyView extends View
{
	private Paint mPaint;
	public static Point point = new Point();

	public MyView(Context context)
	{
		super(context);
		initView();
	}

	private void initView()
	{
			mPaint = new Paint();
	        mPaint.setAntiAlias(true);          //抗锯齿
	        mPaint.setColor(Color.GREEN);//画笔颜色
	        mPaint.setStyle(Paint.Style.FILL);  //画笔风格
	        mPaint.setTextSize(36);             //绘制文字大小，单位px
	        mPaint.setStrokeWidth(5);           //画笔粗细
	}
	
	@Override
	protected void onDraw(Canvas canvas)
	{
		super.onDraw(canvas);
		mPaint.setColor(Color.argb(point.getArgb(), 23, 198, 240));//画笔颜色
		canvas.drawCircle(200, 200,100, mPaint);
	}

	
}
