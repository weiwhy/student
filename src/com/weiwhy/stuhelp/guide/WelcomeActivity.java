package com.weiwhy.stuhelp.guide;

import com.weiwhy.stuhelp.R;
import com.weiwhy.stuhelp.login.LogInActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;

public class WelcomeActivity extends Activity {
	ImageView imagenum,imageView1;
	int i=0;
	private Handler handler;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		imagenum = (ImageView) findViewById(R.id.myimage);
		AnimationDrawable animationDrawable = (AnimationDrawable) imagenum.getBackground();
		animationDrawable.start();
		imageView1=(ImageView) findViewById(R.id.course_icon);
		
		MyThead myThead=new MyThead();
		myThead.start();
		
		handler = new Handler(){
			@Override
			public void handleMessage(Message msg) {
				// TODO Auto-generated method stub
				switch (msg.what) {
				case 1:
					imageView1.setImageResource(R.drawable.num2);
					break;
				case 2:
					imageView1.setImageResource(R.drawable.num1);
					break;
				case 3:
					Intent intent = new Intent();
					intent.setClass(getApplicationContext(), LogInActivity.class);
					startActivity(intent);
					finish();
					
					break;
				default:
					break;
				}
			}
		};
		

//		imagenum.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				Intent intent = new Intent();
//				intent.setClass(getApplicationContext(), LogInActivity.class);
//				startActivity(intent);
//			}
//		});
		
	}
	
	
	class MyThead extends Thread{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (true) {
				try {
					Thread.currentThread().sleep(1000);
					handler.sendEmptyMessage(i++);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
	}
}
