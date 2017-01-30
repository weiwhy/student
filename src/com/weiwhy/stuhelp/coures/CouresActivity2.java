package com.weiwhy.stuhelp.coures;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.NameList;

import com.android.volley.toolbox.StringRequest;
import com.weiwhy.stuhelp.R;
import com.weiwhy.stuhelp.adapter.GridAdapter;
import com.weiwhy.stuhelp.beans.Coures;
import com.weiwhy.stuhelp.beans.ListZhuanYe;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.GridView;

public class CouresActivity2 extends Activity{
	GridView grid_coures;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_coures2);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//强制为横屏
		grid_coures=(GridView) findViewById(R.id.gridView1);
		List<Coures> nameslist=new ArrayList<Coures>();
		
		String[] row_1={" ","周一","周二","周三","周四","周五"};
		
		for (int i = 0; i < 6; i++) {
			Coures coures=new Coures();
			coures.setName(row_1[i]);
			nameslist.add(coures);
		}
		for(int i=0;i<30;i++){
			Coures coures_2=new Coures();
			coures_2.setName("科目"+i);
			nameslist.add(coures_2);
		}
		
		GridAdapter adapter=new GridAdapter(getApplicationContext(), nameslist);
		grid_coures.setAdapter(adapter);
		adapter.notifyDataSetChanged();
	}
	

}
