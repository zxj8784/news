package com.bdqn.news.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdqn.news.entity.News;
import com.bdqn.news.service.NewsService;
import com.bdqn.news.service.impl.NewsServiceImpl;

@SuppressWarnings("serial")
public class News_add extends HttpServlet {


	/**
	 * Constructor of the object.
	 */
	public News_add() {
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
	 
	  int ntid=Integer.valueOf(request.getParameter("ntid"));
	  String ntitle = request.getParameter("ntitle");
	  String nauthor = request.getParameter("nauthor");
	  String nsummary = request.getParameter("nsummary");
	  String ncontent = request.getParameter("ncontent");
	  
	  NewsService newsService = new NewsServiceImpl();
	  News news = new News();
	  
	  news.setNtid(ntid);
	  news.setNauthor(nauthor);
	  news.setNcontent(ncontent);
	  news.setNsummary(nsummary);
	  news.setNtitle(ntitle);
	  
	  newsService.addNews(news);
	  
	  response.sendRedirect("news_add_init");
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
