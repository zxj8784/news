package com.bdqn.news.entity;

/**
 * ��Ӧ���ݱ��е� news ��(ʵ����)
 * ���������ݱ���ֶ�һһ��Ӧ
 * ֵ�Ĵ��ݶ���
 */
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class News {
	
	//ʱ�����ʹ����һ�ַ���(���ں�ʱ��)
	//��ʱ��ȡ��ʱת��Ϊ String �ౣ�洫�� (ʹ�� SimpleDateFormat ��� format()����)
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
	//ʱ�����ʹ���ڶ��ַ���(���ں�ʱ��)
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
