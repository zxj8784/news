package com.bdqn.news.test;

import java.util.List;

import com.bdqn.news.entity.News;
import com.bdqn.news.service.NewsService;
import com.bdqn.news.service.impl.NewsServiceImpl;

public class getNewsTitle_ntid {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	  NewsService newsService = new NewsServiceImpl();  
	  List<News> newsList = newsService.getNewsTitle();
	  
	  List<News> chinaList = newsService.getContantNews(1);
	  List<News> foreignList = newsService.getContantNews(2);
	  List<News> ettmList = newsService.getContantNews(5);
	  for(int i = 0;i < chinaList.size();i ++){
		  System.out.println(chinaList.get(i).getNtid()+"\t"+chinaList.get(i).getNtitle());
	  }
	  
	  System.out.println();
	  for(int i = 0;i < foreignList.size();i ++){
		  System.out.println(foreignList.get(i).getNtid()+"\t"+foreignList.get(i).getNtitle());
	  }
	  
	  System.out.println();
	  for(int i = 0;i < ettmList.size();i ++){
		  System.out.println(ettmList.get(i).getNtid()+"\t"+ettmList.get(i).getNtitle());
	  }

	  System.out.println();
	  for(int i = 0;i < newsList.size();i ++){
		  System.out.println(newsList.get(i).getNtid()+"\t"+newsList.get(i).getNtitle());
	  }
	}

}
