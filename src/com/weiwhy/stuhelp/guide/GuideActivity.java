package com.weiwhy.stuhelp.guide;

import com.weiwhy.stuhelp.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.*;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.*;

public class GuideActivity extends Activity implements OnPageChangeListener {

	private ViewPager viewPager;
	private ImageView[] tips;
	private ImageView[] mImageViews;
	private int[] imgIdArray;

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guide);
		ViewGroup group = (ViewGroup) findViewById(R.id.viewGroup);
		viewPager = (ViewPager) findViewById(R.id.viewPager);

		// 载入图片资源ID
		imgIdArray = new int[] { R.drawable.a, R.drawable.b, R.drawable.c,
				R.drawable.d };

		// 将点点加入到ViewGroup中
		tips = new ImageView[imgIdArray.length];
		for (int i = 0; i < tips.length; i++) {
			ImageView imageView = new ImageView(this);
			/*
			 * 设置布局参数，
			 */
			imageView.setLayoutParams(new LayoutParams(10, 10));
			tips[i] = imageView;
			if (i == 0) {
				tips[i].setBackgroundResource(R.drawable.c1);
			} else {
				tips[i].setBackgroundResource(R.drawable.c2);
			}

			LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
					new ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT,
							LayoutParams.WRAP_CONTENT)); // ????
			layoutParams.leftMargin = 5;
			layoutParams.rightMargin = 5;
			layoutParams.bottomMargin = 25;
			group.addView(imageView, layoutParams); // ??????
		}

		// 将图片装载到数组中
		mImageViews = new ImageView[imgIdArray.length];
		for (int i = 0; i < mImageViews.length; i++) {
			ImageView imageView = new ImageView(this);
			mImageViews[i] = imageView;
			imageView.setBackgroundResource(imgIdArray[i]);
			Log.i("TAG", imgIdArray[i] + "");
			if(i==3){
				imageView.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent=new Intent();
						intent.setClass(getApplicationContext(), WelcomeActivity.class);
						startActivity(intent);
						finish();
					}
				});
			}
		}

		// 设置Adapter
		viewPager.setAdapter(new MyAdapter());
		// 设置监听，主要是设置点点的背景
		viewPager.setOnPageChangeListener(this); // ?????
		// 设置ViewPager的默认项, 设置为长度的 100倍，这样子开始就能往左滑动
		// viewPager.setCurrentItem((mImageViews.length)*5);

	}

	public class MyAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			return mImageViews.length;
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) { // ???????
			return arg0 == arg1;
		}

		@Override
		public void destroyItem(View container, int position, Object object) {
//			System.out.println("销毁了"+position);
			((ViewPager) container).removeView(mImageViews[position
					% mImageViews.length]);
//			if (position==0) {
//				System.out.println("位置为零没有销毁任何View");
//			}else {
//				((ViewPager)container).removeView(mImageViews[position]);	
//			}
			

		}

		/**
		 * 载入图片进去，用当前的position 除以 图片数组长度取余数是关键
		 */
		@Override
		public Object instantiateItem(View container, int position) {
			System.out.println("载入了"+position);
//			 ((ViewPager) container).addView(mImageViews[position
//			 % mImageViews.length], 0);
//			 return mImageViews[position % mImageViews.length];
			((ViewPager)container).addView(mImageViews[position]);
			return mImageViews[position];
		}

	}

	@Override
	public void onPageScrollStateChanged(int arg0) {

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {

	}

	@Override
	public void onPageSelected(int arg0) {
		setImageBackground(arg0 % mImageViews.length);
	}

	private void setImageBackground(int selectItems) {
		for (int i = 0; i < tips.length; i++) {
			if (i == selectItems) {
				tips[i].setBackgroundResource(R.drawable.c1);
			} else {
				tips[i].setBackgroundResource(R.drawable.c2);
			}
		}
	}

}
