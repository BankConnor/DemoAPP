package com.example.viewdemo;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class MyView extends View
{
	 private Paint mPaint;


	    public MyView(Context context) {
	        super(context);
	        init();
	    }

	    public MyView(Context context, AttributeSet attrs) {
	        super(context, attrs);
	        init();
	    }

	    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
	        super(context, attrs, defStyleAttr);
	        init();
	    }

	    private void init(){
	        mPaint = new Paint();
	        mPaint.setAntiAlias(true);          //抗锯齿
	        mPaint.setColor(Color.rgb(239,81,80));//画笔颜色
	        mPaint.setStyle(Paint.Style.FILL);  //画笔风格
	        mPaint.setTextSize(36);             //绘制文字大小，单位px
	        mPaint.setStrokeWidth(5);           //画笔粗细
	    }
	    
	    //重写该方法，在这里绘图
	    @Override
	    protected void onDraw(Canvas canvas) {
	        super.onDraw(canvas);
	        canvas.drawCircle(200, 200, 100, mPaint); 
	        
	    }
	    
	    @Override
	    public void setOnClickListener(OnClickListener l)
	    {
	    	super.setOnClickListener(l);
	    }

}
