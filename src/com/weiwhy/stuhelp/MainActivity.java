package com.weiwhy.stuhelp;

import com.weiwhy.stuhelp.beans.ListZhuanYe;
import com.weiwhy.stuhelp.coures.CouresActivity2;
import com.weiwhy.stuhelp.coures.CourseActivity;
import com.weiwhy.stuhelp.my.MyActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
public class MainActivity extends Activity {

	LinearLayout course_t;
	LinearLayout zhuanye_t;
	LinearLayout stuInfo_t;
	ImageView imageview08;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//编程实现项目的过程
		/*
		 * 1，建立工程，确定包名
		 * 2，换图标和名字
		 * 3，简洁，优化项目框架
		 */
		stuInfo_t=(LinearLayout) findViewById(R.id.stuInfo);
		stuInfo_t.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(getApplicationContext(), MyActivity.class);
				startActivity(intent);
			}
			
		});
		course_t=(LinearLayout) findViewById(R.id.course_t);
		course_t.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(getApplicationContext(),CouresActivity2.class);
				startActivity(intent);
			}
		});
		zhuanye_t=(LinearLayout) findViewById(R.id.zhuanye_t);
		zhuanye_t.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(getApplicationContext(), ListZhuanYe.class);
				startActivity(intent);
			}
		});
		imageview08=(ImageView) findViewById(R.id.ImageView08);
		imageview08.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent2=new Intent();
				intent2.setClass(getApplicationContext(), CouresActivity2.class);
				startActivity(intent2);
			}
		});
	}
}
