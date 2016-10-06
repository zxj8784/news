package com.bdqn.news.entity;

/**
 * 对应数据表中的 news_users 表(实体类)
 * 属性与数据表的字段一一对应
 * 值的传递对象
 */
public class NewsUsers {
	
	private int uid;
	private String uname;
	private String upwd;
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	
}
