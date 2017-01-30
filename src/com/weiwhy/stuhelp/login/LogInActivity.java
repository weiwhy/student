package com.weiwhy.stuhelp.login;

import java.util.HashMap;
import java.util.Map;
import java.util.TooManyListenersException;

import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.weiwhy.stuhelp.MainActivity;
import com.weiwhy.stuhelp.R;
import com.weiwhy.stuhelp.utils.GetUrl;
import com.weiwhy.stuhelp.utils.StaticVar;

import android.app.Activity;
import android.app.DownloadManager.Request;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class LogInActivity extends Activity {
	EditText acount_ET;
	EditText password_TE;
	String account, password;
	Button login_btn;
	LinearLayout language_t;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		acount_ET = (EditText) findViewById(R.id.account_ET);
		password_TE = (EditText) findViewById(R.id.password_ET);
		login_btn=(Button) findViewById(R.id.login_btn);
		language_t=(LinearLayout) findViewById(R.id.language_t);
		language_t.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(getApplicationContext(),LoguageActivity.class );
				startActivity(intent);
			}
		});
		login_btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//System.out.println("select * from stu_login where stu_login_id=\'"+account+"\'");
				account = acount_ET.getText().toString();
				password = password_TE.getText().toString();
				Loggin(account,password);
			}
		});

	}

	private void Loggin(final String account, final String password) {

//		StringRequest request = new StringRequest(Method.GET, GetUrl.getLogin(),
//				new Response.Listener<String>(){
//					
//					@Override
//					public void onResponse(String response) {
//						// TODO Auto-generated method stub
//						try {
//						JSONObject jsonObject=new JSONObject(response);
//						String msg=jsonObject.getString("msg");
//						Log.i("TAG","the Message:"+msg);
//						if (msg.equals("ok")) {
//							Log.i("TAG", "跳转前");
//							Intent intent=new Intent();
//							intent.setClass(getApplicationContext(), MainActivity.class);
//							Log.i("TAG", "开始跳转");
//							startActivity(intent);
//						}
//						
//					} catch (JSONException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					}
//
//				}, new ErrorListener() {
//
//					@Override
//					public void onErrorResponse(VolleyError error) {
//						// TODO Auto-generated method stub
//						System.out.println("请求出错");
//					}
//
//				}) {
//			protected Map<String, String> getparams() {
//				Map<String, String> map = new HashMap<String, String>();
//				map.put("stuNo", account);
//				map.put("password", password);
//				return map;
//			}
//		};
		String url=GetUrl.getLogin()+"?stuNo="+account+"&password="+password;
		//String url1="http://www.baidu.com";
		System.out.println(url);
		StringRequest request=new StringRequest(url,new Response.Listener<String>() {

			@Override
			public void onResponse(String response) {
				Log.i("TAG", response);
				//Toast.makeText(getApplicationContext(), response,1000).show();
				try {
					JSONObject jsonObject=new JSONObject(response);
					String msg=jsonObject.getString("msg");
					Log.i("TAG","the Message:"+msg);
					if (msg.equals("ok")) {
						Log.i("TAG", "跳转前");
						Intent intent=new Intent();
						intent.setClass(getApplicationContext(), MainActivity.class);
						Log.i("TAG", "开始跳转");
						startActivity(intent);
					}
					
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				// TODO Auto-generated method stub
				Log.i("TAG",error.getMessage());
				Toast.makeText(getApplicationContext(),"我是失败", Toast.LENGTH_LONG).show();
			}
		});
		StaticVar.getQueue(getApplicationContext()).add(request);
	}

}
