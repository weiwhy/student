package com.weiwhy.stuhelp.utils;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import android.content.Context;

public class StaticVar {

	public static RequestQueue mQueue;
	public static RequestQueue getQueue(Context context){
		mQueue=Volley.newRequestQueue(context);
		return mQueue;
	}
}
