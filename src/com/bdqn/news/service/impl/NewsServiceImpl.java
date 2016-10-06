package com.bdqn.news.service.impl;

/**
 * ʵ��ҵ����Ӧ news ���ݱ�Ľӿ�
 * @ҵ���
 */
import java.util.*;

import com.bdqn.news.dao.NewsDAO;
import com.bdqn.news.dao.impl.NewsDAOImpl;
import com.bdqn.news.entity.News;
import com.bdqn.news.service.NewsService;

public class NewsServiceImpl implements NewsService {
	NewsDAO newsDao = new NewsDAOImpl();
	//��ҳ����ʾ����������
	private int pageSize=5;
	//������ʾ����ҳ��
	private int totalPage;
	//������������
	public List<News> getNewsTitle() {
		List<News> list = new ArrayList<News>();
		list = newsDao.getNewsTitle();
		return list;
	}
	
	//ͨ������nid��ȡ���ŵ�����
	public List<News> getNewsContent(int nid) {
		
		List<News> allList = this.getNewsTitle();
		List<News> list = new ArrayList<News>();
		for(int i = 0; i < allList.size(); i++){
			if(allList.get(i).getNid()==nid){
				list.add(allList.get(i));
			}
		}
		return list;
	}

	public List<News> getNewsPageSize(int ntid) {
		List<News> list = new ArrayList<News>();
		list = newsDao.getNewsPageSize(ntid);
		return list;
	}
	
	public List<News> getNewsPageSize1(int ntid,int pageNum) {
		List<News> list = new ArrayList<News>();
		list = newsDao.getNewsPageSize1(ntid,pageNum,pageSize);
		return list;
	}
	
	//��ȡ������ʾ����ҳ��
	public int getTotalPage(int ntid) {
		if(getNewsPageSize(ntid).size()%pageSize==0){
			totalPage=getNewsPageSize(ntid).size()/pageSize;
		}else if(getNewsPageSize(ntid).size()%pageSize>0){
			totalPage=getNewsPageSize(ntid).size()/pageSize+1;
		}
		return totalPage;
	}
	
	//���ڡ�������������Ÿ��� ntid ��ֵȡǰ6��
	public List<News> getContantNews(int ntid) {
		int j = 0;
		List<News> allList = this.getNewsTitle();
		List<News> list = new ArrayList<News>();
		for(int i = 0; i < allList.size(); i++){
			if(allList.get(i).getNtid()==ntid){
				list.add(allList.get(i));
				j++;
				if(j==6){break;}
			}
		}
		return list;
	}
	
	//�������
	public void addNews(News news) {
		newsDao.addNews(news);
	}
	
	//ɾ������
	public void deleteNews(News news) {
		newsDao.deleteNews(news);
	}
	
	//�������ŵı���
	public void updateNewsTitle(News news) {
		newsDao.updateNewsTitle(news);
	}

}
