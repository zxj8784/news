package com.bdqn.news.service.impl;

import java.util.List;

import com.bdqn.news.dao.CommentsDAO;
import com.bdqn.news.dao.impl.CommentsDAOImpl;
import com.bdqn.news.entity.Comments;
import com.bdqn.news.service.CommentsService;

public class CommentsServiceImpl implements CommentsService {

	public void addComments(Comments comments) {
		
		CommentsDAO commentsDAO = new CommentsDAOImpl();
		commentsDAO.addComments(comments);

	}

	public List<Comments> getAllComments(int cnid) {
		
		CommentsDAO commentsDAO = new CommentsDAOImpl();
		return commentsDAO.getAllComments(cnid);
	}

}
