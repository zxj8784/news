package com.bdqn.news.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdqn.news.entity.Comments;
import com.bdqn.news.service.CommentsService;
import com.bdqn.news.service.impl.CommentsServiceImpl;

public class context_control extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public context_control() {
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
		doPost(request,response);
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
      
      int cnid =0;
      if(request.getParameter("cnid")!=null){
  		 cnid = Integer.valueOf(request.getParameter("cnid"));
      }
      request.setAttribute("nid", cnid);
      
      String ccontent=request.getParameter("ccontent");
      String cauthor=request.getParameter("cauthor");
      String cip=request.getParameter("cip");
      CommentsService commentsService = new CommentsServiceImpl();
      Comments comments = new Comments();
      comments.setCnid(cnid);
      comments.setCcontent(ccontent);
      comments.setCauthor(cauthor);
      comments.setCip(cip);
      commentsService.addComments(comments);
      request.getRequestDispatcher("context_init").forward(request, response);
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
