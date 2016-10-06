package com.bdqn.news.service;

/**
 * 对应数据表的 topic 表，该接口提供给显示层获取数据的方法，
 * 规范写法：显示层通过业务层接口间接与数据库进行交互
 * @业务层
 */
import java.util.List;

import com.bdqn.news.entity.Topic;

public interface TopicService {
	
	//所有新闻
	public List<Topic> getNewsTopic();
	public void addTopic(Topic topic);
	public List<Topic> getNewsTopic(int tid);
	public void updateTopic(Topic topic);
	public void deleteNews(Topic topic);
}
