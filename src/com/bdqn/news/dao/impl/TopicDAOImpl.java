package com.bdqn.news.dao.impl;

/**
 * 实现类：实现数据表中的 topic 表(接口)
 * 主要作用：负责与数据表 topic 的增加、删除、更改、查询操作
 * @数据层
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
		//占位符需要填充的参数(代表 sql 语句中的"?")，依次写在 Object 类型的数组里，参数变量之间用逗号隔开
		Object[] params={};
		//然后将数组名"params"传入方法中即可(数组可为空值)
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
			System.out.println("插入成功！");
		}
		this.closeResoure(rs, pstmt, conn);
	}
	
	public void updateTopic(Topic topic) {
		String sql = "update topic set tname = ? WHERE tid = ?";
		Object[] params = {topic.getTname(),topic.getTid()};
		int updateRows = this.executeUpdate(sql, params);
		if(updateRows > 0){
			System.out.println("更改成功！");
		}
		this.closeResoure(rs, pstmt, conn);
	}
	
	public void deleteNews(Topic topic) {
		String sql = "delete from topic where tid=?";
		Object[] params = {topic.getTid()};
		int updateRows = this.executeUpdate(sql, params);
		if(updateRows > 0){
			System.out.println("删除成功！");
		}
		this.closeResoure(rs, pstmt, conn);
	}
}
