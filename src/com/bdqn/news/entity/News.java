package com.bdqn.news.entity;

/**
 * 对应数据表中的 news 表(实体类)
 * 属性与数据表的字段一一对应
 * 值的传递对象
 */
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class News {
	
	//时间类型处理第一种方法(日期和时间)
	//将时间取出时转换为 String 类保存传递 (使用 SimpleDateFormat 类的 format()方法)
	SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
	Date date =new Date();
	private int nid;
	private int ntid;
	private String ntitle;
	private String nauthor;
	private String ncreatedate=sd.format(date);
	private String npicpath;
	private String ncontent;
	private Date createdate;
	
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	//时间类型处理第二种方法(日期和时间)
	private Timestamp nmodifydate;
	private String nsummary;
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public int getNtid() {
		return ntid;
	}
	public void setNtid(int ntid) {
		this.ntid = ntid;
	}
	public String getNtitle() {
		return ntitle;
	}
	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}
	public String getNauthor() {
		return nauthor;
	}
	public void setNauthor(String nauthor) {
		this.nauthor = nauthor;
	}
	public String getNcreatedate() {
		return ncreatedate;
	}
	public void setNcreatedate(String ncreatedate) {
		this.ncreatedate = ncreatedate;
	}
	public String getNpicpath() {
		return npicpath;
	}
	public void setNpicpath(String npicpath) {
		this.npicpath = npicpath;
	}
	public String getNcontent() {
		return ncontent;
	}
	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}
	public Timestamp getNmodifydate() {
		return nmodifydate;
	}
	public void setNmodifydate(Timestamp nmodifydate) {
		this.nmodifydate = nmodifydate;
	}
	public String getNsummary() {
		return nsummary;
	}
	public void setNsummary(String nsummary) {
		this.nsummary = nsummary;
	}
	
}
