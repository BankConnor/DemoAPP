package com.MyViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.puzzle.MainActivity;
import com.example.puzzle.R;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
public class MyRelativeLayout extends RelativeLayout implements OnClickListener
{
	/*
	 * 对外扩展属性 由用户进行指定 
	 * 但是需要指定默认值 因为有可能用户并没有指定
	 */
	private int n = 2;
	private int maring = 7;
	private Bitmap bit = BitmapFactory.decodeResource(getResources(), R.drawable.a);
	public boolean isFist = true;//装填ImageView只需要一次
	private ImageView one;
	private ImageView two;
	private RelativeLayout adminRe;
	private MainActivity main;
	private int count=0;
	
	public List<Bitmap> bits;
	
	public MainActivity getMain()
	{
		return main;
	}

	public void setMain(MainActivity main)
	{
		this.main = main;
	}

	public MyRelativeLayout(Context context, AttributeSet attrs, int defStyle)
	{
		super(context, attrs, defStyle);
	}

	public MyRelativeLayout(Context context, AttributeSet attrs)
	{
		super(context, attrs);
	}

	public MyRelativeLayout(Context context)
	{
		super(context);
	}
	
	/* (non-Javadoc)
	 * @see android.widget.RelativeLayout#onMeasure(int, int)
	 */
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
	{
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		
		/*
		 * 因为最终拼图父容器是正方形
		 * 但是用户有可能竖屏或者横屏
		 * 所以取两者最小值来做整体正方形的长度
		 */
		int value = Math.min(getMeasuredHeight(), getMeasuredWidth());
		setMeasuredDimension(value, value);//设置成正方形
		
		if(isFist)
		{
			Log.i("Connor", "测绘");
			int oWitht = (value-getPaddingLeft()-getPaddingRight()-(n-1)*maring)/n;//计算出每个ImageView的宽度=高度
			
			/*
			 * 创建ImageView 显示每个拼图碎片
			 */
			for (int i = 0; i < n*n; i++)
			{
				ImageView imageView = new ImageView(getContext());
				imageView.setId(i+1);//设置每个ImageView的id id不可以被重复 否则会覆盖掉 使用新的id值对应的View
				imageView.setTag(i);
				imageView.setOnClickListener(this);
				
				RelativeLayout.LayoutParams params = new LayoutParams(oWitht, oWitht);//定义每个子视图的容器大小
				
				if(i>=n)
				{
					//在非第一行，开始对当前的ImageView设定布局位置
					
					/*
					 * RelativeLayout指定当前的ImageView的布局位置
					 * 参数1：位置
					 * 参数2：相对于那个View指定的
					 */
					params.addRule(RelativeLayout.BELOW, i-n+1);
					params.topMargin = maring;//间距
				}
				
				if(i%n!=0)
				{
					//在非第一列 开始对当前的ImageView设定布局位置
					params.addRule(RelativeLayout.RIGHT_OF, i);
					params.leftMargin = maring;
				}
				
				//最后只剩下下标是0的ImageView没有被指定 但是无需指定 因为他将默认在容器的左上角
				imageView.setImageBitmap(getBitmap().get(i));
				imageView.setScaleType(ScaleType.FIT_XY);
				addView(imageView, params);//把当前的ImageView添加this容器中
			}
			isFist = false;
		}	
	}
	
	public  List<Bitmap>  getBitmap()
	{
		List<Bitmap> bits = new ArrayList<Bitmap>();
		int width = bit.getWidth()/n;
		int height = bit.getHeight()/n;
		
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				Bitmap bit = Bitmap.createBitmap(this.bit, j*width, i*height, width, height);
				bits.add(bit);
			}
		}
		
		return bits;
	}



	public int getN()
	{
		return n;
	}

	public void setN(int n)
	{
		this.n = n;
	}

	public int getMaring()
	{
		return maring;
	}

	public void setMaring(int maring)
	{
		this.maring = maring;
	}

	public Bitmap getBit()
	{
		return bit;
	}

	public void setBit(Bitmap bit)
	{
		this.bit = bit;
	}

	@Override
	public void onClick(View v)
	{
		if(one==null)
		{
			//当用户第一次点击的时候把当前的ImageView赋值
			one = (ImageView) v;
			one.setColorFilter(Color.argb(255/2, 241,140,146));
		}
		else if(two==null)
		{
			//当用户第二次点击 因为第一次点击点击已经被赋值ImageView 并且需要建立动画图层
			two = (ImageView) v;
			
			setAndim();//开启动画
			
			
		}
	}

	private void setAndim()
	{
		//1.建立动画图层
		adminRe = new RelativeLayout(getContext());
		RelativeLayout.LayoutParams adminLp = new LayoutParams(getWidth(), getHeight());
		adminRe.setLayoutParams(adminLp);
		//adminRe.setBackgroundColor(Color.parseColor("#00000000"));
		addView(adminRe);//图层建立完毕 图层覆盖到MyRelativeLayout上
		
		//2.拷贝当前点击两个的ImageView 添加到动画图层上
		ImageView cOne = new ImageView(getContext());//重新创建一个ImageView 一个View不能添加到两个父容器上
		RelativeLayout.LayoutParams onelp = new LayoutParams(one.getWidth(), one.getHeight());
		onelp.leftMargin = one.getLeft();//建立左间距
		onelp.topMargin = one.getTop();//建立上间距 这样间距的建立可以达到刚好每个拷贝的ImageView都可以覆盖掉底下的图层
		cOne.setColorFilter(Color.argb(255/2, 241,140,146));
		cOne.setImageBitmap(getBitmap().get((Integer)one.getTag()));
		adminRe.addView(cOne, onelp);
		
		ImageView cTwo = new ImageView(getContext());//重新创建一个ImageView 一个View不能添加到两个父容器上
		RelativeLayout.LayoutParams twolp = new LayoutParams(two.getWidth(), two.getHeight());
		twolp.leftMargin = two.getLeft();//建立左间距
		twolp.topMargin = two.getTop();//建立上间距 这样间距的建立可以达到刚好每个拷贝的ImageView都可以覆盖掉底下的图层
		cTwo.setColorFilter(Color.argb(255/2, 241,140,146));
		cTwo.setImageBitmap(getBitmap().get((Integer)two.getTag()));
		adminRe.addView(cTwo, twolp);
		
		//3.建立动画
		TranslateAnimation oneTran = new TranslateAnimation(0, two.getLeft()-one.getLeft(), 0, two.getTop()-one.getTop());
		oneTran.setDuration(500);
		oneTran.setFillAfter(true);
		cOne.setAnimation(oneTran);
		
		TranslateAnimation twoTran = new TranslateAnimation(0, one.getLeft()-two.getLeft(), 0, one.getTop()-two.getTop());
		twoTran.setDuration(500);
		twoTran.setFillAfter(true);
		cTwo.setAnimation(twoTran);
		
		twoTran.setAnimationListener(new AnimationListener()
		{
			
			@Override
			public void onAnimationStart(Animation animation)
			{
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation)
			{
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation)
			{
				int sumcount = 0;
				//动画结束 更新MyRelativeLayout图层
				int one_tag = (Integer) one.getTag();
				int two_tag = (Integer) two.getTag();
				one.setImageBitmap(getBitmap().get(two_tag));
				one.setTag(two_tag);
				one.clearColorFilter();
				two.setImageBitmap(getBitmap().get(one_tag));
				two.setTag(one_tag);
				removeView(adminRe);//删除掉动画图层
				count = MyRelativeLayout.this.getChildCount();
				for (int i = 0; i < MyRelativeLayout.this.getChildCount(); i++)
				{
					ImageView imageView =  (ImageView) MyRelativeLayout.this.getChildAt(i);
					if((Integer)imageView.getTag()+1==imageView.getId())
					{
						++sumcount;
					}
					if(sumcount==count)
					{
						Toast.makeText(getContext(), "OK", Toast.LENGTH_LONG).show();
						return;
					}
				}
				one = null;
				two = null;
			}
		});
	}

	

}
