package com.bdqn.news.dao;

/**
 * ��Ӧ���ݱ��е� news_users ��(�ӿ�)
 * �淶д����ҵ���ͨ�����ݲ�ӿڼ�ӵ������ݿ���н���
 * @���ݲ�
 */
import com.bdqn.news.entity.NewsUsers;

public interface NewsUsersDAO {
	
	public NewsUsers getNewsUsers(NewsUsers user);
	public void addNewsUsers(NewsUsers user);
	public void updateNewsUsers(NewsUsers user);
	public void deleteNewsUsers(NewsUsers user);
}
