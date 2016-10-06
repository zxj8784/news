package com.bdqn.news.entity;

/**
 * 对应数据表中的 topic 表(实体类)
 * 属性与数据表的字段一一对应
 * 值的传递对象
 */
public class Topic {
	
	private int tid;
	private String tname;
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	
}
