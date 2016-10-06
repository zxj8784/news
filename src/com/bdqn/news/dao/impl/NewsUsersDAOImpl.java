package com.bdqn.news.dao.impl;

/**
 * ʵ���ࣺʵ�����ݱ��е� news_users ��(�ӿ�)
 * ��Ҫ���ã����������ݱ� news_users �����ӡ�ɾ�������ġ���ѯ����
 * @���ݲ�
 */
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bdqn.news.dao.BaseDAO;
import com.bdqn.news.dao.NewsUsersDAO;
import com.bdqn.news.entity.NewsUsers;

public class NewsUsersDAOImpl extends BaseDAO implements NewsUsersDAO {
	
	//��ѯ����
	public NewsUsers getNewsUsers(NewsUsers user) {
		
		String sql = "select * from news_users where uname = ? and upwd= ?";
		//ռλ����Ҫ���Ĳ���(���� sql ����е�"?")������д�� Object ���͵��������������֮���ö��Ÿ���
		Object[] params={user.getUname(),user.getUpwd()};
		//Ȼ��������"params"���뷽���м���(�����Ϊ��ֵ)
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
	
	//��������
	public void addNewsUsers(NewsUsers user) {
		String sql = "";
		Object[] params = {};
		int updateRows = this.executeUpdate(sql, params);
		if(updateRows > 0){
			System.out.println("����ɹ���");
		}
		this.closeResoure(rs, pstmt, conn);
	}
	
	//��������
	public void updateNewsUsers(NewsUsers user) {
		String sql = "";
		Object[] params = {};
		int updateRows = this.executeUpdate(sql, params);
		if(updateRows > 0){
			System.out.println("���³ɹ���");
		}
		this.closeResoure(rs, pstmt, conn);
	}
	
	//ɾ������
	public void deleteNewsUsers(NewsUsers user) {
		String sql = "";
		Object[] params = {};
		int updateRows = this.executeUpdate(sql, params);
		if(updateRows > 0){
			System.out.println("ɾ���ɹ���");
		}
		this.closeResoure(rs, pstmt, conn);
	}
	
}
