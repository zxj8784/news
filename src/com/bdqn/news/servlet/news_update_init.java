package com.bdqn.news.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdqn.news.entity.News;
import com.bdqn.news.entity.Topic;
import com.bdqn.news.service.NewsService;
import com.bdqn.news.service.TopicService;
import com.bdqn.news.service.impl.NewsServiceImpl;
import com.bdqn.news.service.impl.TopicServiceImpl;

public class news_update_init extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public news_update_init() {
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
	  TopicService topicService = new TopicServiceImpl();
	  List<Topic> topicList = topicService.getNewsTopic();
	  request.setAttribute("topicList", topicList);
	  
	  String tname = request.getParameter("tname");
	  request.setAttribute("tname", tname);
	  
	  int nid=48;
	  if(request.getParameter("nid")!=null){
	      nid=Integer.valueOf(request.getParameter("nid"));
	      request.setAttribute("cnid", nid);
	  }
	  NewsService newsService = new NewsServiceImpl();
	  List<News> newsList = newsService.getNewsContent(nid);
	  request.setAttribute("newsList", newsList);
	  request.getRequestDispatcher("newsUpdate.jsp").forward(request,response);
	  
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
