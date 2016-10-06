package com.bdqn.news.test;

import com.bdqn.news.entity.News;
import com.bdqn.news.service.NewsService;
import com.bdqn.news.service.impl.NewsServiceImpl;

public class addNewsTest {

	/**
	 * 添加新闻
	 * @param args
	 */
	public static void main(String[] args) {
		NewsService newsService = new NewsServiceImpl();
		  News news = new News();
		  news.setNtid(1);
		  news.setNauthor("樱木花子");
		  news.setNcontent("要嫁人了");
		  news.setNsummary("nsummary");
		  news.setNtitle("东京娱乐新闻");
		  newsService.addNews(news);
	}

}
