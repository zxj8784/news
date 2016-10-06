package com.bdqn.news.service;

import java.util.List;

import com.bdqn.news.entity.Comments;

public interface CommentsService {
	
	public void addComments(Comments comments);
	public List<Comments> getAllComments(int cnid);
}
