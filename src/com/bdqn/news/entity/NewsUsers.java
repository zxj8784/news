package com.bdqn.news.entity;

/**
 * ��Ӧ���ݱ��е� news_users ��(ʵ����)
 * ���������ݱ���ֶ�һһ��Ӧ
 * ֵ�Ĵ��ݶ���
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
