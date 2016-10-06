package com.bdqn.news.test;

import com.bdqn.news.entity.News;
import com.bdqn.news.service.NewsService;
import com.bdqn.news.service.impl.NewsServiceImpl;

public class deleteNewsTest {

	/**
	 * …æ≥˝–¬Œ≈≤‚ ‘
	 * @param args
	 */
	public static void main(String[] args) {
		NewsService newsService = new NewsServiceImpl();
		News news = new News();
		news.setNtitle("123");
		newsService.deleteNews(news);
	}

}
