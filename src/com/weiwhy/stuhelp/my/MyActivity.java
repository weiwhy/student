package com.weiwhy.stuhelp.my;
import org.json.JSONObject;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.Response.ErrorListener;
import com.android.volley.toolbox.StringRequest;
import com.weiwhy.stuhelp.R;
import com.weiwhy.stuhelp.utils.GetUrl;
import com.weiwhy.stuhelp.utils.StaticVar;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MyActivity extends Activity {

	TextView text_name,text_sex,text_xuehao,text_zhuanye,text_nianji,text_shengri,
				text_banji,text_sushe,text_phone,text_qq,text_wechat,text_dizhi,
				text_id;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stu_info);
		init();
	}

	private void init() {
		text_name=(TextView) findViewById(R.id.text_name);
		text_sex=(TextView) findViewById(R.id.text_sex);
		text_xuehao=(TextView) findViewById(R.id.text_xuehao);
		text_zhuanye=(TextView) findViewById(R.id.text_zhuanye);
		text_nianji=(TextView) findViewById(R.id.text_nianji);
		text_shengri=(TextView) findViewById(R.id.text_shengri);
		text_banji=(TextView) findViewById(R.id.text_banji);
		text_sushe=(TextView) findViewById(R.id.text_sushe);
		text_phone=(TextView) findViewById(R.id.text_phone);
		text_qq=(TextView) findViewById(R.id.text_qq);
		text_wechat=(TextView) findViewById(R.id.text_wechat);
		text_dizhi=(TextView) findViewById(R.id.text_dizhi);
		text_id=(TextView) findViewById(R.id.text_id);
		String url=GetUrl.getStuInfo();
		StringRequest request=new StringRequest(url+"?stuNo=150110318",
				new Response.Listener<String>() {

					@Override
					public void onResponse(String response) {
						// TODO Auto-generated method stub
						try {
							JSONObject jsonObject=new JSONObject(response);
							JSONObject jsonObject2 = jsonObject.getJSONObject("values");
							String birthday=jsonObject2.getString("birthday").trim().substring(0,10);
							text_shengri.setText(birthday);
							String sushe=jsonObject2.getString("sushe").trim();
							text_sushe.setText(sushe);
							String idnumber=jsonObject2.getString("idnumber").trim();
							text_id.setText(idnumber);
							String sex=jsonObject2.getString("sex").trim();
							text_sex.setText(sex);
							String stuName=jsonObject2.getString("stuName").trim();
							text_name.setText(stuName);
							String department=jsonObject2.getString("department").trim();
							
							String banji=jsonObject2.getString("banji").trim();
							text_banji.setText(banji);
							String shengyudi=jsonObject2.getString("shengyudi").trim();
							text_dizhi.setText(shengyudi);
							String nianji=jsonObject2.getString("nianji").trim();
							text_nianji.setText(nianji);
							String stuNo=jsonObject2.getString("stuNo").trim();
							text_xuehao.setText(stuNo);
							String  zhuanye=jsonObject2.getString("zhuanye").trim();
							text_zhuanye.setText(zhuanye);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				},
				new ErrorListener(){

					@Override
					public void onErrorResponse(VolleyError error) {
						// TODO Auto-generated method stub
						Log.i("TAG",error.getMessage());
					}
				});
		StaticVar.getQueue(getApplicationContext()).add(request);
		
	}
}
