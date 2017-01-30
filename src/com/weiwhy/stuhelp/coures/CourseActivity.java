package com.weiwhy.stuhelp.coures;

import java.util.ArrayList;
import java.util.List;

import com.weiwhy.stuhelp.R;
import com.weiwhy.stuhelp.adapter.CourseList_Adapter;
import com.weiwhy.stuhelp.beans.CourseInfor;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class CourseActivity extends Activity {
	List<CourseInfor> list_course;
	ListView course_lv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_coures);
		course_lv=(ListView) findViewById(R.id.course_lv);
		CourseInfor course1=new CourseInfor(R.drawable.a, "生物学", "2016-12-9");
		CourseInfor course2=new CourseInfor(R.drawable.myanimation, "物理学", "2016-12-9");
		CourseInfor course3=new CourseInfor(R.drawable.chang_pass, "天文学", "2016-12-9");
		list_course=new ArrayList<CourseInfor>();
		list_course.add(course1);
		list_course.add(course2);
		list_course.add(course3);
		
		CourseList_Adapter courseList_Adapter=new CourseList_Adapter(list_course,this.getApplicationContext());
		course_lv.setAdapter(courseList_Adapter);
		
	}
}
