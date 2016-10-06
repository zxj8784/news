package com.bdqn.news.test;

import com.bdqn.news.entity.News;
import com.bdqn.news.service.NewsService;
import com.bdqn.news.service.impl.NewsServiceImpl;

public class upateNewsTest {

	/**
	 * 新闻更新测试
	 * @param args
	 */
	public static void main(String[] args) {
		NewsService newsService = new NewsServiceImpl();
		News news = new News();
		news.setNid(197);
		news.setNtitle("wwwww");
		newsService.updateNewsTitle(news);
	}

}
