package com.weiwhy.stuhelp.utils;

public class GetUrl {

	//public static String login_url="http://192.168.31.45:8080/School/TestSql";
	public static String url="http://192.168.2.125:8080/Students/";
	public static String getLogin(){
		return url+"LogIn";
	}
	public static String getAllInfo(){
		return url+"GetAllInfo";
	}
	public static String getStuInfo(){
		return url+"EetStuInfo";
	}
}
