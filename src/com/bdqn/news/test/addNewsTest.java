package com.bdqn.news.test;

import com.bdqn.news.entity.News;
import com.bdqn.news.service.NewsService;
import com.bdqn.news.service.impl.NewsServiceImpl;

public class addNewsTest {

	/**
	 * �������
	 * @param args
	 */
	public static void main(String[] args) {
		NewsService newsService = new NewsServiceImpl();
		  News news = new News();
		  news.setNtid(1);
		  news.setNauthor("ӣľ����");
		  news.setNcontent("Ҫ������");
		  news.setNsummary("nsummary");
		  news.setNtitle("������������");
		  newsService.addNews(news);
	}

}
