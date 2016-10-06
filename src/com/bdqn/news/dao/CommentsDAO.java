package com.bdqn.news.dao;

import java.util.List;

import com.bdqn.news.entity.Comments;

public interface CommentsDAO {
	
	public void addComments(Comments comments);
	public List<Comments> getAllComments(int cnid);
}
