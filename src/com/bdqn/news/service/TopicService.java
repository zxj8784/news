package com.bdqn.news.service;

/**
 * ��Ӧ���ݱ�� topic ���ýӿ��ṩ����ʾ���ȡ���ݵķ�����
 * �淶д������ʾ��ͨ��ҵ���ӿڼ�������ݿ���н���
 * @ҵ���
 */
import java.util.List;

import com.bdqn.news.entity.Topic;

public interface TopicService {
	
	//��������
	public List<Topic> getNewsTopic();
	public void addTopic(Topic topic);
	public List<Topic> getNewsTopic(int tid);
	public void updateTopic(Topic topic);
	public void deleteNews(Topic topic);
}
