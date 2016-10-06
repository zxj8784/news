package com.bdqn.news.dao;

/**
 * 对应数据表中的 topic 表(接口)
 * 规范写法：业务层通过数据层接口间接的与数据库进行交互
 * @数据层
 */
import java.util.List;

import com.bdqn.news.entity.Topic;

public interface TopicDAO {
	public List<Topic> getNewsTopic();
	public void addTopic(Topic topic);
	public void updateTopic(Topic topic);
	public void deleteNews(Topic topic);
}
