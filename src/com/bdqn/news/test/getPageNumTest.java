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

public class getPageNumTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NewsService newsService1 = new NewsServiceImpl();
        List<News> pageNumList = new ArrayList<News>();
        pageNumList = newsService1.getNewsPageSize(1);
 	     
 	     for(int i = 0; i < pageNumList.size();i++){
 	    	 System.out.println(i+1+"\t"+pageNumList.get(i).getNid()+"\t"+pageNumList.get(i).getNtitle());
 	     }
	}

}
