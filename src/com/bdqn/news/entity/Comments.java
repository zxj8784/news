package com.bdqn.news.entity;

/**
 * ��Ӧ���ݱ��е� comments ��(ʵ����)
 * ���������ݱ���ֶ�һһ��Ӧ
 * ֵ�Ĵ��ݶ���
 */
import java.sql.Timestamp;

public class Comments {
	
	private int cid;
	private int cnid;
	private String ccontent;
	private Timestamp cdate;
	private String cip;
	private String cauthor;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getCnid() {
		return cnid;
	}
	public void setCnid(int cnid) {
		this.cnid = cnid;
	}
	public String getCcontent() {
		return ccontent;
	}
	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}
	public Timestamp getCdate() {
		return cdate;
	}
	public void setCdate(Timestamp cdate) {
		this.cdate = cdate;
	}
	public String getCip() {
		return cip;
	}
	public void setCip(String cip) {
		this.cip = cip;
	}
	public String getCauthor() {
		return cauthor;
	}
	public void setCauthor(String cauthor) {
		this.cauthor = cauthor;
	}
	
}
