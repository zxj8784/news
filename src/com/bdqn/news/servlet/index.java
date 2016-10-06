package com.bdqn.news.servlet;

import java.io.IOException;

import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bdqn.news.entity.News;
import com.bdqn.news.entity.Topic;
import com.bdqn.news.service.NewsService;
import com.bdqn.news.service.TopicService;
import com.bdqn.news.service.impl.NewsServiceImpl;
import com.bdqn.news.service.impl.TopicServiceImpl;

public class index extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doDelete method of the servlet. <br>
	 *
	 * This method is called when a HTTP delete request is received.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doDelete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

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

		//response.setContentType("text/html");
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
		  
		  //传递用户名
		  String user = "请输入用户名";
		  if((String)session.getAttribute("userName")!=null){
		     user = (String)session.getAttribute("userName");
		  }
		  request.setAttribute("user", user);
		  
		  NewsService newsService = new NewsServiceImpl();
		  List<News> newsList = newsService.getNewsTitle();
		  List<News> chinaList = newsService.getContantNews(1);
		  List<News> foreignList = newsService.getContantNews(2);
		  List<News> ettmList = newsService.getContantNews(5);
		  
		  //国内、国外和娱乐新闻取前6条
		  request.setAttribute("newsList", newsList);
		  request.setAttribute("chinaList", chinaList);
		  request.setAttribute("foreignList", foreignList);
		  request.setAttribute("ettmList", ettmList);
		  
		  List<Topic> topicList = new ArrayList<Topic>();
		  TopicService topicService = new TopicServiceImpl();
		  topicList = topicService.getNewsTopic();
		  request.setAttribute("topicList", topicList);

		  //分类分页显示新闻代码段
		  int ntid =1;
		  if(request.getParameter("ntid")!=null){
		  		ntid = Integer.valueOf(request.getParameter("ntid"));
		  }
		  request.setAttribute("ntid", ntid);
		  NewsService newsService1 = new NewsServiceImpl();
		  List<News> pageNumList = new ArrayList<News>();
		  int pageNum=1;
		  if(request.getParameter("pageNum")!=null){
		  		pageNum = Integer.valueOf(request.getParameter("pageNum"));
		  }
		  pageNumList = newsService1.getNewsPageSize1(ntid, pageNum);
		  int totalPageCount=newsService1.getTotalPage(ntid);
		  request.setAttribute("pageNumList", pageNumList);
		  request.setAttribute("pageNum", pageNum);
		  request.setAttribute("totalPageCount", totalPageCount);
		  request.getRequestDispatcher("MyJsp.jsp").forward(request,response);
	}

	/**
	 * The doPut method of the servlet. <br>
	 *
	 * This method is called when a HTTP put request is received.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Put your code here
	}

	/**
	 * Returns information about the servlet, such as 
	 * author, version, and copyright. 
	 *
	 * @return String information about this servlet
	 */
	public String getServletInfo() {
		return "This is my default servlet created by Eclipse";
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
