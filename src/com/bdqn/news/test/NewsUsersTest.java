package com.bdqn.news.test;

/**
 * ������(�� main ����)
 * @��ʾ��(����̨)
 */
import com.bdqn.news.entity.NewsUsers;
import com.bdqn.news.service.NewsUsersService;
import com.bdqn.news.service.impl.NewsUsersServiceImpl;

public class NewsUsersTest {

	/**
	 * ������(�����Ƿ��õ�����)
	 * @param args
	 * 
	 */
	
	public static void main(String[] args) {
		
		NewsUsersService users = new NewsUsersServiceImpl();
		NewsUsers user = new NewsUsers();
		user.setUname("admin");
		user.setUpwd("123456");
		System.out.println("������"+users.getNewsUsers(user).getUname()+"\t���룺"+users.getNewsUsers(user).getUpwd());
	}
}
