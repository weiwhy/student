package com.weiwhy.stuhelp.zhuanye;

import java.util.ArrayList;
import java.util.List;

import com.weiwhy.stuhelp.R;
import com.weiwhy.stuhelp.adapter.ZhuanYeAdapter;
import com.weiwhy.stuhelp.beans.ListZhuanYe;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class Activity_Zhuanye extends Activity {

	ListView list_zhuanye;
	String[] name={"软件技术","计算机网络技术","通信技术","物联网应用技术","电子信息工程"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_zhuanye);
		list_zhuanye=(ListView) findViewById(R.id.list_zhuanye);
		List<ListZhuanYe> names=new ArrayList<ListZhuanYe>();
		
		
		for (int i = 0; i <20; i++) {
			ListZhuanYe listZhuanYe=new ListZhuanYe();
			listZhuanYe.setName(name[i]);
			names.add(listZhuanYe);
		}
		
		ZhuanYeAdapter adapter=new ZhuanYeAdapter(names, this);
		list_zhuanye.setAdapter(adapter);
	}
}
