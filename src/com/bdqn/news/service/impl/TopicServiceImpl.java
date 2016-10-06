package com.bdqn.news.service.impl;

/**
 * 实现业务层对应 topic 数据表的接口
 * @业务层
 */
import java.util.ArrayList;
import java.util.List;

import com.bdqn.news.dao.TopicDAO;
import com.bdqn.news.dao.impl.TopicDAOImpl;
import com.bdqn.news.entity.Topic;
import com.bdqn.news.service.TopicService;

public class TopicServiceImpl implements TopicService {

	public List<Topic> getNewsTopic() {
		
		List<Topic> list = new ArrayList<Topic>();
		TopicDAO topicDao = new TopicDAOImpl();
		list = topicDao.getNewsTopic();
		return list;
	}
	
    public List<Topic> getNewsTopic(int tid) {
		
		List<Topic> allList = new ArrayList<Topic>();
		List<Topic> list = new ArrayList<Topic>();
		allList = this.getNewsTopic();
		for(int i = 0;i < allList.size();i++){
			if(allList.get(i).getTid()==tid){
				list.add(allList.get(i));
			}
		}
		return list;
	}

	public void addTopic(Topic topic) {
		TopicDAO topicDao = new TopicDAOImpl();
		topicDao.addTopic(topic);
	}

	public void updateTopic(Topic topic) {
		TopicDAO topicDao = new TopicDAOImpl();
		topicDao.updateTopic(topic);
	}

	public void deleteNews(Topic topic) {
		TopicDAO topicDao = new TopicDAOImpl();
		topicDao.deleteNews(topic);
	}
}
