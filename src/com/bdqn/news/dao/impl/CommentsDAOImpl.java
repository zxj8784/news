package com.bdqn.news.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bdqn.news.dao.BaseDAO;
import com.bdqn.news.dao.CommentsDAO;
import com.bdqn.news.entity.Comments;

public class CommentsDAOImpl extends BaseDAO implements CommentsDAO {

	public void addComments(Comments comments) {
		String sql = "insert into comments(CNID,CCONTENT,CDATE,CIP,CAUTHOR) values(?,?,'2016-09-03 18:13:26',?,?)";
		Object[] params = {comments.getCnid(),comments.getCcontent(),comments.getCip(),comments.getCauthor()};
		int updateRows = this.executeUpdate(sql, params);
		if(updateRows>0){
			System.out.println("ÆÀÂÛ³É¹¦£¡");
		}
		this.closeResoure(rs, pstmt, conn);
	}

	public List<Comments> getAllComments(int cnid) {
		List<Comments> list = new ArrayList<Comments>();
		Comments comments = null;
		String sql = "select * from comments where cnid=?";
		Object[] params={cnid};
		ResultSet rs = this.getResultSet(sql,params);
		try {
			while(rs.next()){
				comments = new Comments();
				comments.setCnid(rs.getInt("cnid"));
				comments.setCid(rs.getInt("cid"));
				comments.setCip(rs.getString("cip"));
				comments.setCdate(rs.getTimestamp("cdate"));
				comments.setCcontent(rs.getString("ccontent"));
				comments.setCauthor(rs.getString("cauthor"));
				list.add(comments);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeResoure(rs, pstmt, conn);
		}
		return list;
	}

}
