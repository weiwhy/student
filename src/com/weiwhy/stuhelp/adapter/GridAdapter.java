package com.weiwhy.stuhelp.adapter;

import java.util.List;

import org.w3c.dom.Text;

import com.weiwhy.stuhelp.R;
import com.weiwhy.stuhelp.beans.Coures;
import com.weiwhy.stuhelp.beans.ListZhuanYe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter {

	LayoutInflater inflater;
	List<Coures> list;
	Context context;
	
	public GridAdapter(Context convertView,List<Coures> couresName) {
		this.list=couresName;
		this.context=convertView;
		inflater=LayoutInflater.from(convertView);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		convertView = inflater.inflate(R.layout.item_text, null);
		TextView view2= (TextView) convertView.findViewById(R.id.textView1);
		view2.setText(list.get(position).getName());
		return convertView;
	}

}
