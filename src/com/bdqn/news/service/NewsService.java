package com.bdqn.news.service;

/**
 * 对应数据表的 news 表，该接口提供给显示层获取数据的方法，
 * 规范写法：显示层通过业务层接口间接与数据库进行交互
 * @业务层
 */
import java.util.List;

import com.bdqn.news.entity.News;

public interface NewsService {
	
	//获取新闻数据表的所有数据
	public List<News> getNewsTitle();
	//通过nid获取新闻数据表的内容
	public List<News> getNewsContent(int nid);
	//获取新闻显示的总页数
	public int getTotalPage(int ntid);
	//分页查询数据库(获取单页上所显示的新闻条数)
	public List<News> getNewsPageSize(int ntid);
	//国内、国外或娱乐新闻
	public List<News> getContantNews(int ntid);
	//分页
	public List<News> getNewsPageSize1(int ntid,int pageNum);
	
	public void addNews(News news);
	public void deleteNews(News news);
	public void updateNewsTitle(News news);
	
}
