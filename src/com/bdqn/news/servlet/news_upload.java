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
		
		Timestamp today = new Timestamp(System.currentTimeMillis()); //��ȡ��ǰʱ��
		
		News news = new News();
		
		//��������ǰ�ж��Ƿ�Ϊ�ļ��ϴ�
		boolean isMultiPath = ServletFileUpload.isMultipartContent(request);
		//�����ϴ��ļ��������������ַ
		String uploadStr = request.getSession().getServletContext().getRealPath("imgFile/");
		File uploadFile = new File(uploadStr);
		 //�ж��Ƿ����-->�����ھʹ���
		if(!uploadFile.exists()){
			uploadFile.mkdir();
		}
		if(isMultiPath){ 
			//�ļ��ϴ������� ServletFileUpload -->����д�õ�
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			//��������
			try {
				List<FileItem> items = upload.parseRequest(request);
				Iterator<FileItem> newsItor = items.iterator();
				while(newsItor.hasNext()){
					FileItem comment = newsItor.next();
					if(comment.isFormField()){ //�����  �ı�  ���ؼ�
						String name = comment.getFieldName();//��ȡ�ı������� -->name��ֵ
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
					else{//�����  �ļ�  ���ؼ�
						//String[] org = new String[]{".jpg",".gif",".ico",".png"};//�����ϴ�������
						String FileName = comment.getName(); //ȫ·�� --> ����ѡ���ļ�����ʾ��·����ַ
						if(FileName != null && !FileName.equals("")){
							File imgFile = new File(FileName);
							File saveFile = new File(uploadFile, imgFile.getName());//���ļ��ϴ���ָ��λ��
							System.out.println(saveFile.getAbsolutePath());
							comment.write(saveFile);//�ϴ� 
							news.setNpicpath(imgFile.getName());
						}
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			//���뵱ǰʱ��
			news.setCreatedate(today);
			//����
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
