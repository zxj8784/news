package com.bdqn.news.dao.impl;

/**
 * ʵ���ࣺʵ�����ݱ��е� topic ��(�ӿ�)
 * ��Ҫ���ã����������ݱ� topic �����ӡ�ɾ�������ġ���ѯ����
 * @���ݲ�
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bdqn.news.dao.BaseDAO;
import com.bdqn.news.dao.TopicDAO;
import com.bdqn.news.entity.Topic;

public class TopicDAOImpl extends BaseDAO implements TopicDAO {

	public List<Topic> getNewsTopic() {
		
		List<Topic> list = new ArrayList<Topic>();
		Topic topic = null;
		String sql = "select * from topic";
		//ռλ����Ҫ���Ĳ���(���� sql ����е�"?")������д�� Object ���͵��������������֮���ö��Ÿ���
		Object[] params={};
		//Ȼ��������"params"���뷽���м���(�����Ϊ��ֵ)
		ResultSet rs = this.getResultSet(sql,params);
		try {
			while(rs.next()){
				topic = new Topic();
				topic.setTid(rs.getInt("tid"));
				topic.setTname(rs.getString("tname"));
				list.add(topic);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeResoure(rs, pstmt, conn);
		}
		return list;
	}

	public void addTopic(Topic topic) {
		String sql = "insert into topic(tname) values(?)";
		Object[] params = {topic.getTname()};
		int updateRows = this.executeUpdate(sql, params);
		if(updateRows>0){
			System.out.println("����ɹ���");
		}
		this.closeResoure(rs, pstmt, conn);
	}
	
	public void updateTopic(Topic topic) {
		String sql = "update topic set tname = ? WHERE tid = ?";
		Object[] params = {topic.getTname(),topic.getTid()};
		int updateRows = this.executeUpdate(sql, params);
		if(updateRows > 0){
			System.out.println("���ĳɹ���");
		}
		this.closeResoure(rs, pstmt, conn);
	}
	
	public void deleteNews(Topic topic) {
		String sql = "delete from topic where tid=?";
		Object[] params = {topic.getTid()};
		int updateRows = this.executeUpdate(sql, params);
		if(updateRows > 0){
			System.out.println("ɾ���ɹ���");
		}
		this.closeResoure(rs, pstmt, conn);
	}
}
