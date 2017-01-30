package com.weiwhy.stuhelp.adapter;

import java.util.List;
import java.util.zip.Inflater;

import com.weiwhy.stuhelp.R;
import com.weiwhy.stuhelp.beans.CourseInfor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CourseList_Adapter extends BaseAdapter {
	List<CourseInfor> list;
	LayoutInflater inflater;
	public CourseList_Adapter(List list,Context convertView) {
		this.list=list;
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
		View view=inflater.inflate(R.layout.item_coures, null);
		ImageView course_icon=(ImageView) view.findViewById(R.id.course_icon);
		TextView course_title=(TextView) view.findViewById(R.id.news_title);
		TextView course_time=(TextView) view.findViewById(R.id.course_time);
		
		course_icon.setImageResource(list.get(position).getCourseIcon());
		course_title.setText(list.get(position).getCouresName());
		course_time.setText(list.get(position).getCouresTime());
		
		return view;
	}

}
