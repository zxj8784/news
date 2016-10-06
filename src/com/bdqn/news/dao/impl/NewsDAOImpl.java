package com.bdqn.news.dao.impl;

/**
 * 实现类：实现数据表中的 news 表(接口)
 * 主要作用：负责与数据表 news 的增加、删除、更改、查询操作
 * @数据层
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
		//占位符需要填充的参数(代表 sql 语句中的"?")，依次写在 Object 类型的数组里，参数变量之间用逗号隔开
		Object[] params={};
		//然后将数组名"params"传入方法中即可(数组可为空值)
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
		//占位符需要填充的参数(代表 sql 语句中的"?")，依次写在 Object 类型的数组里，参数变量之间用逗号隔开
		Object[] params={ntid};
		//然后将数组名"params"传入方法中即可(数组可为空值)
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
		//占位符需要填充的参数(代表 sql 语句中的"?")，依次写在 Object 类型的数组里，参数变量之间用逗号隔开
		Object[] params={ntid,(pageNum-1)*pageSize,pageSize};
		//然后将数组名"params"传入方法中即可(数组可为空值)
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
			System.out.println("插入成功！");
		}
		this.closeResoure(rs, pstmt, conn);
	}

	public void deleteNews(News news) {
		String sql = "delete from news where nid=?";
		Object[] params = {news.getNid()};
		int updateRows = this.executeUpdate(sql, params);
		if(updateRows > 0){
			System.out.println("删除成功！");
		}
		this.closeResoure(rs, pstmt, conn);
	}

	public void updateNewsTitle(News news) {
		String sql = "update news set ntid=?, ntitle = ?, nauthor=?, nsummary=?, ncontent=? WHERE nid = ?";
		Object[] params = {news.getNtid(),news.getNtitle(),news.getNauthor(),news.getNsummary(),news.getNcontent(),news.getNid()};
		int updateRows = this.executeUpdate(sql, params);
		if(updateRows > 0){
			System.out.println("更改成功！");
		}
		this.closeResoure(rs, pstmt, conn);
	}

}
