package com.bdqn.news.service.impl;

/**
 * ʵ��ҵ����Ӧ news_user ���ݱ�Ľӿ�
 * @ҵ���
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
