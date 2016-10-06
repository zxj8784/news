package com.bdqn.news.test;

/**
 * 测试类(含 main 方法)
 * @显示层(控制台)
 */
import java.util.ArrayList;
import java.util.List;

import com.bdqn.news.entity.Topic;
import com.bdqn.news.service.TopicService;
import com.bdqn.news.service.impl.TopicServiceImpl;

public class TopicTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<Topic> topicList = new ArrayList<Topic>();
		TopicService topicService = new TopicServiceImpl();
		Topic topic=new Topic();
		topic.setTid(32);
		//topic.setTname("建军节");
		//topicService.updateTopic(topic);
		topicService.deleteNews(topic);
		//topicList = topicService.getNewsTopic();
		for(int i = 0; i < topicList.size(); i++){
			System.out.println(i+1+"\t"+topicList.get(i).getTname());
		}
	}

}
