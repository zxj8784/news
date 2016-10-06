package com.bdqn.news.test;

import java.util.ArrayList;
import java.util.List;

import com.bdqn.news.entity.Comments;
import com.bdqn.news.service.CommentsService;
import com.bdqn.news.service.impl.CommentsServiceImpl;

public class commentsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CommentsService commentsService=new CommentsServiceImpl();
		List<Comments> commentsList=new ArrayList<Comments>();
		commentsList=commentsService.getAllComments(73);
		for(int i=0;i<commentsList.size();i++){
			System.out.println(commentsList.get(i).getCcontent());
		}

	}

}
