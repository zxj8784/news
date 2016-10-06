package com.bdqn.news.service.impl;

/**
 * 实现业务层对应 news 数据表的接口
 * @业务层
 */
import java.util.*;

import com.bdqn.news.dao.NewsDAO;
import com.bdqn.news.dao.impl.NewsDAOImpl;
import com.bdqn.news.entity.News;
import com.bdqn.news.service.NewsService;

public class NewsServiceImpl implements NewsService {
	NewsDAO newsDao = new NewsDAOImpl();
	//单页所显示的新闻条数
	private int pageSize=5;
	//新闻显示的总页数
	private int totalPage;
	//表中所有数据
	public List<News> getNewsTitle() {
		List<News> list = new ArrayList<News>();
		list = newsDao.getNewsTitle();
		return list;
	}
	
	//通过新闻nid获取新闻的内容
	public List<News> getNewsContent(int nid) {
		
		List<News> allList = this.getNewsTitle();
		List<News> list = new ArrayList<News>();
		for(int i = 0; i < allList.size(); i++){
			if(allList.get(i).getNid()==nid){
				list.add(allList.get(i));
			}
		}
		return list;
	}

	public List<News> getNewsPageSize(int ntid) {
		List<News> list = new ArrayList<News>();
		list = newsDao.getNewsPageSize(ntid);
		return list;
	}
	
	public List<News> getNewsPageSize1(int ntid,int pageNum) {
		List<News> list = new ArrayList<News>();
		list = newsDao.getNewsPageSize1(ntid,pageNum,pageSize);
		return list;
	}
	
	//获取新闻显示的总页数
	public int getTotalPage(int ntid) {
		if(getNewsPageSize(ntid).size()%pageSize==0){
			totalPage=getNewsPageSize(ntid).size()/pageSize;
		}else if(getNewsPageSize(ntid).size()%pageSize>0){
			totalPage=getNewsPageSize(ntid).size()/pageSize+1;
		}
		return totalPage;
	}
	
	//国内、国外或娱乐新闻根据 ntid 键值取前6条
	public List<News> getContantNews(int ntid) {
		int j = 0;
		List<News> allList = this.getNewsTitle();
		List<News> list = new ArrayList<News>();
		for(int i = 0; i < allList.size(); i++){
			if(allList.get(i).getNtid()==ntid){
				list.add(allList.get(i));
				j++;
				if(j==6){break;}
			}
		}
		return list;
	}
	
	//添加新闻
	public void addNews(News news) {
		newsDao.addNews(news);
	}
	
	//删除新闻
	public void deleteNews(News news) {
		newsDao.deleteNews(news);
	}
	
	//更改新闻的标题
	public void updateNewsTitle(News news) {
		newsDao.updateNewsTitle(news);
	}

}
