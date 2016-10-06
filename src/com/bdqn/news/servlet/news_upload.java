package com.bdqn.news.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.bdqn.news.entity.News;
import com.bdqn.news.service.NewsService;
import com.bdqn.news.service.impl.NewsServiceImpl;

public class news_upload extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public news_upload() {
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
		
		NewsService nse = new NewsServiceImpl();
		request.setCharacterEncoding("utf-8");
		
		Timestamp today = new Timestamp(System.currentTimeMillis()); //获取当前时间
		
		News news = new News();
		
		//解析请求前判断是否为文件上传
		boolean isMultiPath = ServletFileUpload.isMultipartContent(request);
		//定义上传文件到服务器储存地址
		String uploadStr = request.getSession().getServletContext().getRealPath("imgFile/");
		File uploadFile = new File(uploadStr);
		 //判断是否存在-->不存在就创建
		if(!uploadFile.exists()){
			uploadFile.mkdir();
		}
		if(isMultiPath){ 
			//文件上传核心类 ServletFileUpload -->别人写好的
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			//解析请求
			try {
				List<FileItem> items = upload.parseRequest(request);
				Iterator<FileItem> newsItor = items.iterator();
				while(newsItor.hasNext()){
					FileItem comment = newsItor.next();
					if(comment.isFormField()){ //如果是  文本  表单控件
						String name = comment.getFieldName();//获取文本框名字 -->name的值
						if(name.equals("ntitle")){
							news.setNtitle(comment.getString("utf8"));		
						}
						else if(name.equals("nauthor")){
							news.setNauthor(comment.getString("utf8"));
							
						}
						else if(name.equals("nsummary")){
							news.setNsummary(comment.getString("utf8"));
							
						}
						else if(name.equals("ncontent")){
							news.setNcontent(comment.getString("utf8"));
						}
						else if(name.equals("ntid")){
							news.setNtid(Integer.parseInt(comment.getString()));
						}
						
					}
					else{//如果是  文件  表单控件
						//String[] org = new String[]{".jpg",".gif",".ico",".png"};//允许上传的类型
						String FileName = comment.getName(); //全路径 --> 就是选择文件后显示的路径地址
						if(FileName != null && !FileName.equals("")){
							File imgFile = new File(FileName);
							File saveFile = new File(uploadFile, imgFile.getName());//把文件上传到指定位置
							System.out.println(saveFile.getAbsolutePath());
							comment.write(saveFile);//上传 
							news.setNpicpath(imgFile.getName());
						}
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			//传入当前时间
			news.setCreatedate(today);
			//新增
			nse.addNews(news);
			response.sendRedirect("news_add.jsp");
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
