package com.weiwhy.stuhelp.beans;

public class CourseInfor {

	int courseIcon;
	String couresName;
	String couresTime;
	public CourseInfor(int icon,String couresName,String couresTime) {
		this.courseIcon=icon;
		this.couresName=couresName;
		this.couresTime=couresTime;
		// TODO Auto-generated constructor stub
	}
	public int getCourseIcon() {
		return courseIcon;
	}
	public void setCourseIcon(int courseIcon) {
		this.courseIcon = courseIcon;
	}
	public String getCouresName() {
		return couresName;
	}
	public void setCouresName(String couresName) {
		this.couresName = couresName;
	}
	public String getCouresTime() {
		return couresTime;
	}
	public void setCouresTime(String couresTime) {
		this.couresTime = couresTime;
	}
}
