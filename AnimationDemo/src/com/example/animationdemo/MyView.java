package com.example.animationdemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class MyView extends View
{
	private String start;
	private String end;
	private String text;
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
	{
		// TODO Auto-generated method stub
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		try
		{
			OutputStream outputStream = new FileOutputStream(new File("/mnt/sdcard/Debug.txt"));
			outputStream.write((widthMeasureSpec+"  =  "+heightMeasureSpec+" ---"+System.currentTimeMillis()).getBytes());
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}
	
	@Override
	protected void onLayout(boolean changed, int left, int top, int right, int bottom)
	{
		super.onLayout(changed, left, top, right, bottom);
		Log.i("Connor", left+" - "+top+" - "+right+" - "+bottom);
		try
		{
			OutputStream outputStream = new FileOutputStream(new File("/mnt/sdcard/Debug2.txt"));
			outputStream.write((left+" - "+top+" - "+right+" - "+bottom).getBytes());
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}
	public MyView(Context context, AttributeSet attrs, int defStyleAttr)
	{
		super(context, attrs, defStyleAttr);
	}

	public MyView(Context context, AttributeSet attrs)
	{
		super(context, attrs);//系统属性交给父类去处理
		try
		{
			OutputStream outputStream = new FileOutputStream(new File("/mnt/sdcard/Debug3.txt"));
			outputStream.write(String.valueOf((System.currentTimeMillis())).getBytes());
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
		/*
		 * 参数1：AttributeSet里放置有系统内置属性和自定义属性
		 * context.obtainStyledAttributes(attrs, R.styleable.myarrts);
		 * 取出自定义属性 因为系统不会处理自定义属性 因为系统无法识别自定义的规则
		 * 参数2：自定义属性集合的R文件的ID值
		 */
		TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.myarrts);
		 start = array.getString(R.styleable.myarrts_start);
		 end = array.getString(R.styleable.myarrts_end);
		 text = array.getString(R.styleable.myarrts_text);
		array.recycle();//释放资源 GC并不会回收该资源对象
	}

	public MyView(Context context)
	{
		super(context);
	}
	
	public void setText(String text)
	{
		this.text = text;
	}
	
	@Override
	protected void onDraw(Canvas canvas)
	{
		canvas.clipRect(0, 0, getWidth(), getHeight());//画板大小 ---> 设置画板大小是View的大小
		canvas.drawColor(Color.GREEN);
		super.onDraw(canvas);
		Log.i("Connor", getWidth()+"'");
		Paint paint = new Paint();//画笔
		paint.setTextSize(50);//绘制文字时候的大小
		paint.setColor(Color.CYAN);//画笔的颜色
		
		Rect rect = new Rect();//矩形
		paint.getTextBounds(text, 0, text.length(), rect);//计算绘制的文字所占据的矩形大小 因为所有视图都是矩形
		canvas.drawText(text, getWidth()/2-rect.width()/2, getHeight()/2+rect.height(), paint);//备注
	}
	
	
}
