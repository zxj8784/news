package com.bdqn.news.test;

/**
 * 测试类(含 main 方法)
 * @显示层(控制台)
 */
import com.bdqn.news.entity.NewsUsers;
import com.bdqn.news.service.NewsUsersService;
import com.bdqn.news.service.impl.NewsUsersServiceImpl;

public class NewsUsersTest {

	/**
	 * 测试类(看看是否拿到数据)
	 * @param args
	 * 
	 */
	
	public static void main(String[] args) {
		
		NewsUsersService users = new NewsUsersServiceImpl();
		NewsUsers user = new NewsUsers();
		user.setUname("admin");
		user.setUpwd("123456");
		System.out.println("姓名："+users.getNewsUsers(user).getUname()+"\t密码："+users.getNewsUsers(user).getUpwd());
	}
}
