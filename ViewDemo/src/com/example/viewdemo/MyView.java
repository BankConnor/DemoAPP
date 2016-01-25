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
	        mPaint.setAntiAlias(true);          //�����
	        mPaint.setColor(Color.rgb(239,81,80));//������ɫ
	        mPaint.setStyle(Paint.Style.FILL);  //���ʷ��
	        mPaint.setTextSize(36);             //�������ִ�С����λpx
	        mPaint.setStrokeWidth(5);           //���ʴ�ϸ
	    }
	    
	    //��д�÷������������ͼ
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
