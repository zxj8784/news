package com.bdqn.news.dao;

/**
 * 对应数据表中的 news 表(接口)
 * 规范写法：业务层通过数据层接口间接的与数据库进行交互
 * @数据层
 */
import java.util.List;

import com.bdqn.news.entity.News;

public interface NewsDAO {
	
	public List<News> getNewsTitle();
	//分页查询数据库的数据，每次拿"pageSize"条数据放置在一页上
	public List<News> getNewsPageSize(int ntid);
	public List<News> getNewsPageSize1(int ntid,int pageNum,int pageSize);
	public void addNews(News news);
	public void deleteNews(News news);
	public void updateNewsTitle(News news);
}
