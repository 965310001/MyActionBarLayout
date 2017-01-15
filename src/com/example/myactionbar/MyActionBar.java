package com.example.myactionbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MyActionBar extends RelativeLayout {
	//声明我们需要的控件，这些控件是和attrs.xml中我们定义的属性对应的
	private Button leftButton, rightButton;
	private TextView tvTitle;//actionbar控件上显示的标题
	
	private int leftTextColor;
	private Drawable leftBackground;
	private String leftText;
	
	private int rightTextColor;
	private Drawable rightBackground;
	private String rightText;
	
	private String title;
	private int titleTextColor;//显示文字的颜色
	private float titleTextSize;//显示出来的文字的大小
	
	private Drawable actionBarBackground;
	
	private LayoutParams leftParams, rightParams, titleParams;//设置控件的布局
	private MyActionbarClickListener listener;//定义接口对象
	
	public interface MyActionbarClickListener//自定义接口
	{
		void leftClick();
		void rightClick();
	}	
	public void setOnMyActionbarClickListener(MyActionbarClickListener listener)//暴露给调用者的方法，这样调用者便可以将具体实现以匿名内部类的
	//形式传递进来
	{
		this.listener = listener;
	}

	public MyActionBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		//使用TypedArray,获取在attrs.xml中我们自定义的一系列属性,并将属性赋给我们定义的控件,然后我们便可以从TypedArray中获取到这些属性值
		TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyActionBar);
		leftTextColor = typedArray.getColor(R.styleable.MyActionBar_leftTextColor, 0);
		leftBackground = typedArray.getDrawable(R.styleable.MyActionBar_leftBackground);
		leftText = typedArray.getString(R.styleable.MyActionBar_leftText);
		
		rightTextColor = typedArray.getColor(R.styleable.MyActionBar_rightTextColor, 0);
		rightBackground = typedArray.getDrawable(R.styleable.MyActionBar_rightBackground);
		rightText = typedArray.getString(R.styleable.MyActionBar_rightText);
		
		title = typedArray.getString(R.styleable.MyActionBar_title);
		titleTextColor = typedArray.getColor(R.styleable.MyActionBar_titleTextColor, 0);
		titleTextSize = typedArray.getDimension(R.styleable.MyActionBar_titleTextSize, 14);
		
		actionBarBackground = typedArray.getDrawable(R.styleable.MyActionBar_actionbarBackground);
		typedArray.recycle();//回收此变量，节约资源，避免由于缓存导致的其他问题
		// 实例化我们定义的控件
		leftButton = new Button(context);
		rightButton = new Button(context);
		tvTitle = new TextView(context);
		// 将我们获取到的属性分别赋给相应的控件
		leftButton.setTextColor(leftTextColor);
		leftButton.setBackground(leftBackground);
		leftButton.setText(leftText);
		rightButton.setTextColor(rightTextColor);
		rightButton.setBackground(rightBackground);
		rightButton.setText(rightText);
		tvTitle.setText(title);
		tvTitle.setTextColor(titleTextColor);
		tvTitle.setTextSize(titleTextSize);
		tvTitle.setGravity(Gravity.CENTER);//设置标题居中
		
		setBackground(actionBarBackground);//设置viewGroup(即两个button和一个tittle)的背景颜色
		//以上我们已经设置好了各个控件的属性，那接下来就需要把这些控件放置到viewGroup中了，即我们需要设置一下他们的布局属性了
		leftParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);//设置左Button的width和height
		leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);//设置左边button的布局属性，即左对齐
		addView(leftButton, leftParams);//将左边button加入到viewGroup中
		rightParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
		addView(rightButton, rightParams);
		titleParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		titleParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
		addView(tvTitle, titleParams);
		
		leftButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				listener.leftClick();
			}
		});
		rightButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				listener.rightClick();
			}
		});
	}
	public void setLeftIsVisible(boolean flag)
	{
		if (flag) {
			leftButton.setVisibility(VISIBLE);
		}else {
			leftButton.setVisibility(GONE);
		}
	}

}
