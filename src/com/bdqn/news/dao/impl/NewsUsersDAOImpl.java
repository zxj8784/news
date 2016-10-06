package com.bdqn.news.dao.impl;

/**
 * 实现类：实现数据表中的 news_users 表(接口)
 * 主要作用：负责与数据表 news_users 的增加、删除、更改、查询操作
 * @数据层
 */
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bdqn.news.dao.BaseDAO;
import com.bdqn.news.dao.NewsUsersDAO;
import com.bdqn.news.entity.NewsUsers;

public class NewsUsersDAOImpl extends BaseDAO implements NewsUsersDAO {
	
	//查询数据
	public NewsUsers getNewsUsers(NewsUsers user) {
		
		String sql = "select * from news_users where uname = ? and upwd= ?";
		//占位符需要填充的参数(代表 sql 语句中的"?")，依次写在 Object 类型的数组里，参数变量之间用逗号隔开
		Object[] params={user.getUname(),user.getUpwd()};
		//然后将数组名"params"传入方法中即可(数组可为空值)
		ResultSet rs = this.getResultSet(sql,params);
		NewsUsers user1 = null;
		try {
			while(rs.next()){
				user1 = new NewsUsers();
				user1.setUname(rs.getString("uname"));
				user1.setUpwd(rs.getString("upwd"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeResoure(rs, pstmt, conn);
		}
		return user1;
	}
	
	//插入数据
	public void addNewsUsers(NewsUsers user) {
		String sql = "";
		Object[] params = {};
		int updateRows = this.executeUpdate(sql, params);
		if(updateRows > 0){
			System.out.println("插入成功！");
		}
		this.closeResoure(rs, pstmt, conn);
	}
	
	//更新数据
	public void updateNewsUsers(NewsUsers user) {
		String sql = "";
		Object[] params = {};
		int updateRows = this.executeUpdate(sql, params);
		if(updateRows > 0){
			System.out.println("更新成功！");
		}
		this.closeResoure(rs, pstmt, conn);
	}
	
	//删除数据
	public void deleteNewsUsers(NewsUsers user) {
		String sql = "";
		Object[] params = {};
		int updateRows = this.executeUpdate(sql, params);
		if(updateRows > 0){
			System.out.println("删除成功！");
		}
		this.closeResoure(rs, pstmt, conn);
	}
	
}
