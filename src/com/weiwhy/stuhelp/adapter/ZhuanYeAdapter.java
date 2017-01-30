package com.weiwhy.stuhelp.adapter;

import java.util.List;

import com.weiwhy.stuhelp.R;
import com.weiwhy.stuhelp.beans.ListZhuanYe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ZhuanYeAdapter extends BaseAdapter {

	List<ListZhuanYe> names;
	Context context;
	LayoutInflater inflater;
	public ZhuanYeAdapter(List<ListZhuanYe> names,Context convertView) {
		this.names=names;
		this.context=convertView;
		inflater=LayoutInflater.from(convertView);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return names.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return getItem(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (convertView==null) {
			convertView = inflater.inflate(R.layout.item_text, null);
		}
		
		TextView view2= (TextView) convertView.findViewById(R.id.textView1);
		view2.setText(names.get(position).getName());
		return convertView;
	}

}
