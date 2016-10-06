package com.bdqn.news.service.impl;

/**
 * 实现业务层对应 news_user 数据表的接口
 * @业务层
 */
import com.bdqn.news.dao.NewsUsersDAO;
import com.bdqn.news.dao.impl.NewsUsersDAOImpl;
import com.bdqn.news.entity.NewsUsers;
import com.bdqn.news.service.NewsUsersService;

public class NewsUsersServiceImpl implements NewsUsersService {

	public NewsUsers getNewsUsers(NewsUsers user) {
		NewsUsersDAO userDao = new NewsUsersDAOImpl();
		return userDao.getNewsUsers(user);
	}
}
