package com.bdqn.news.dao.impl;

/**
 * ʵ���ࣺʵ�����ݱ��е� news ��(�ӿ�)
 * ��Ҫ���ã����������ݱ� news �����ӡ�ɾ�������ġ���ѯ����
 * @���ݲ�
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bdqn.news.dao.BaseDAO;
import com.bdqn.news.dao.NewsDAO;
import com.bdqn.news.entity.News;

public class NewsDAOImpl extends BaseDAO implements NewsDAO {

	public List<News> getNewsTitle() {
		
		List<News> list = new ArrayList<News>();
		News news = null;
		
		String sql = "select * from news";
		//ռλ����Ҫ���Ĳ���(���� sql ����е�"?")������д�� Object ���͵��������������֮���ö��Ÿ���
		Object[] params={};
		//Ȼ��������"params"���뷽���м���(�����Ϊ��ֵ)
		ResultSet rs = this.getResultSet(sql,params);
		try {
			while(rs.next()){
				news = new News();
				getNewList(news, rs);
				list.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeResoure(rs, pstmt, conn);
		}
		return list;
	}

	private void getNewList(News news, ResultSet rs) throws SQLException {
		news.setNid(rs.getInt("nid"));
		news.setNtid(rs.getInt("ntid"));
		news.setNsummary(rs.getString("nsummary"));
		news.setNpicpath(rs.getString("npicpath"));
		news.setNcontent(rs.getString("ncontent"));
		news.setNauthor(rs.getString("nauthor"));
		news.setNmodifydate(rs.getTimestamp("nmodifydate"));
		news.setNcreatedate(rs.getString("ncreatedate"));
		news.setNtitle(rs.getString("ntitle"));
	}

	public List<News> getNewsPageSize(int ntid) {
		List<News> list = new ArrayList<News>();
		News news = null;
		String sql = "select * from news where ntid = ?";
		//ռλ����Ҫ���Ĳ���(���� sql ����е�"?")������д�� Object ���͵��������������֮���ö��Ÿ���
		Object[] params={ntid};
		//Ȼ��������"params"���뷽���м���(�����Ϊ��ֵ)
		ResultSet rs = this.getResultSet(sql,params);
		try {
			while(rs.next()){
				news=new News();
				getNewList(news, rs);
				list.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeResoure(rs, pstmt, conn);
		}
		return list;
	}
	
	public List<News> getNewsPageSize1(int ntid,int pageNum,int pageSize) {
		List<News> list = new ArrayList<News>();
		News news = null;
		String sql = "select * from news where ntid = ? limit ?,?";
		//ռλ����Ҫ���Ĳ���(���� sql ����е�"?")������д�� Object ���͵��������������֮���ö��Ÿ���
		Object[] params={ntid,(pageNum-1)*pageSize,pageSize};
		//Ȼ��������"params"���뷽���м���(�����Ϊ��ֵ)
		ResultSet rs = this.getResultSet(sql,params);
		try {
			while(rs.next()){
				news=new News();
				getNewList(news, rs);
				list.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeResoure(rs, pstmt, conn);
		}
		return list;
	}

	public void addNews(News news) {
		String sql = "insert into news(ntid,ntitle,NAUTHOR,NCREATEDATE,NPICPATH," +
				"NCONTENT,NMODIFYDATE,NSUMMARY) values(?,?,?,null,?,?,null,?,?)";
		Object[] params = {news.getNtid(),news.getNtitle(),news.getNauthor(),news.getNpicpath(),news.getNcontent(),news.getNsummary()};
		int updateRows = this.executeUpdate(sql, params);
		if(updateRows>0){
			System.out.println("����ɹ���");
		}
		this.closeResoure(rs, pstmt, conn);
	}

	public void deleteNews(News news) {
		String sql = "delete from news where nid=?";
		Object[] params = {news.getNid()};
		int updateRows = this.executeUpdate(sql, params);
		if(updateRows > 0){
			System.out.println("ɾ���ɹ���");
		}
		this.closeResoure(rs, pstmt, conn);
	}

	public void updateNewsTitle(News news) {
		String sql = "update news set ntid=?, ntitle = ?, nauthor=?, nsummary=?, ncontent=? WHERE nid = ?";
		Object[] params = {news.getNtid(),news.getNtitle(),news.getNauthor(),news.getNsummary(),news.getNcontent(),news.getNid()};
		int updateRows = this.executeUpdate(sql, params);
		if(updateRows > 0){
			System.out.println("���ĳɹ���");
		}
		this.closeResoure(rs, pstmt, conn);
	}

}
