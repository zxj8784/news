package com.bdqn.news.service;

/**
 * 对应数据表的 news_user 表，该接口提供给显示层获取数据的方法，
 * 规范写法：显示层通过业务层接口间接与数据库进行交互
 * @业务层
 */
import com.bdqn.news.entity.NewsUsers;

public interface NewsUsersService {
	
	public NewsUsers getNewsUsers(NewsUsers user);
}
