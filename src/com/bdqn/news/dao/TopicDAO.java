package com.bdqn.news.dao;

/**
 * ��Ӧ���ݱ��е� topic ��(�ӿ�)
 * �淶д����ҵ���ͨ�����ݲ�ӿڼ�ӵ������ݿ���н���
 * @���ݲ�
 */
import java.util.List;

import com.bdqn.news.entity.Topic;

public interface TopicDAO {
	public List<Topic> getNewsTopic();
	public void addTopic(Topic topic);
	public void updateTopic(Topic topic);
	public void deleteNews(Topic topic);
}
