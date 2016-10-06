package com.bdqn.news.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bdqn.news.entity.NewsUsers;
import com.bdqn.news.service.NewsUsersService;
import com.bdqn.news.service.impl.NewsUsersServiceImpl;

public class doLogin extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public doLogin() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
        //获取用户名
        String uname = request.getParameter("uname");
        //获取密码
        String upwd = request.getParameter("upwd");
        //调用用户业务,需要导包
        NewsUsersService userService = new NewsUsersServiceImpl();
        //执行业务登录业务
        NewsUsers user = new NewsUsers();
        user.setUname(uname);
        user.setUpwd(upwd);
        NewsUsers user1 = userService.getNewsUsers(user);
        
        //如果密码相等就登录
        if(user1 !=null){
            session.setAttribute("userName", user1.getUname());
            response.sendRedirect("admin_init");
        }else{
            response.sendRedirect("index");
            //response.setHeader("refresh", "0;url = ../News/MyJsp.jsp");
        }
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
