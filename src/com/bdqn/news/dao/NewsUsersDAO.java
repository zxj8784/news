package com.bdqn.news.dao;

/**
 * 对应数据表中的 news_users 表(接口)
 * 规范写法：业务层通过数据层接口间接的与数据库进行交互
 * @数据层
 */
import com.bdqn.news.entity.NewsUsers;

public interface NewsUsersDAO {
	
	public NewsUsers getNewsUsers(NewsUsers user);
	public void addNewsUsers(NewsUsers user);
	public void updateNewsUsers(NewsUsers user);
	public void deleteNewsUsers(NewsUsers user);
}
