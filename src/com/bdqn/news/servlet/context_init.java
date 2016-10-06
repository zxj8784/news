package com.bdqn.news.servlet;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdqn.news.entity.Comments;
import com.bdqn.news.entity.News;
import com.bdqn.news.service.CommentsService;
import com.bdqn.news.service.NewsService;
import com.bdqn.news.service.impl.CommentsServiceImpl;
import com.bdqn.news.service.impl.NewsServiceImpl;

public class context_init extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public context_init() {
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
	  
	  NewsService newsService = new NewsServiceImpl();
	  List<News> chinaList = newsService.getContantNews(1);
	  List<News> foreignList = newsService.getContantNews(2);
	  List<News> ettmList = newsService.getContantNews(5);
	  
	  //评论数据显示
	  CommentsService commentsService=new CommentsServiceImpl();
	  List<Comments> commentsList=new ArrayList<Comments>();
	  
	  //国内、国外和娱乐新闻取前6条
	  request.setAttribute("chinaList", chinaList);
	  request.setAttribute("foreignList", foreignList);
	  request.setAttribute("ettmList", ettmList);
	  
	  int nid=48;
	  if(request.getParameter("nid")!=null){
	      nid=Integer.valueOf(request.getParameter("nid"));
	  }
	  
	  //处理页面传递参数nid
	  if(request.getParameter("cnid")!=null){
	      nid=Integer.valueOf(request.getParameter("cnid")); 
	  }
	  commentsList=commentsService.getAllComments(nid);
	  request.setAttribute("commentsList", commentsList);
	  List<News> contentList = newsService.getNewsContent(nid);
	  request.setAttribute("contentList", contentList);
	  request.getRequestDispatcher("context.jsp").forward(request, response);
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
