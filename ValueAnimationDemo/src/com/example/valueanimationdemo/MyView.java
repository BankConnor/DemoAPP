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
	        mPaint.setAntiAlias(true);          //�����
	        mPaint.setColor(Color.GREEN);//������ɫ
	        mPaint.setStyle(Paint.Style.FILL);  //���ʷ��
	        mPaint.setTextSize(36);             //�������ִ�С����λpx
	        mPaint.setStrokeWidth(5);           //���ʴ�ϸ
	}
	
	@Override
	protected void onDraw(Canvas canvas)
	{
		super.onDraw(canvas);
		mPaint.setColor(Color.argb(point.getArgb(), 23, 198, 240));//������ɫ
		canvas.drawCircle(200, 200,100, mPaint);
	}

	
}
