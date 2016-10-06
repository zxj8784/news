package com.bdqn.news.test;

/**
 * 测试类(含 main 方法)
 * @显示层(控制台)
 */
import java.util.ArrayList;
import java.util.List;

import com.bdqn.news.entity.News;
import com.bdqn.news.service.NewsService;
import com.bdqn.news.service.impl.NewsServiceImpl;

public class NewsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		NewsService newsService = new NewsServiceImpl();
		List<News> newsList = new ArrayList<News>();
		newsList = newsService.getNewsContent(49);
		for(int i=0;i<newsList.size();i++){
			System.out.println(newsList.get(i).getNtitle()+"\n"+newsList.get(i).getNcontent()+"\t"+newsList.get(i).getNcreatedate());
		}
	}
}
