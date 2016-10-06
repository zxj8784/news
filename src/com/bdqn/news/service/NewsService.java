package com.bdqn.news.service;

/**
 * ��Ӧ���ݱ�� news ���ýӿ��ṩ����ʾ���ȡ���ݵķ�����
 * �淶д������ʾ��ͨ��ҵ���ӿڼ�������ݿ���н���
 * @ҵ���
 */
import java.util.List;

import com.bdqn.news.entity.News;

public interface NewsService {
	
	//��ȡ�������ݱ����������
	public List<News> getNewsTitle();
	//ͨ��nid��ȡ�������ݱ������
	public List<News> getNewsContent(int nid);
	//��ȡ������ʾ����ҳ��
	public int getTotalPage(int ntid);
	//��ҳ��ѯ���ݿ�(��ȡ��ҳ������ʾ����������)
	public List<News> getNewsPageSize(int ntid);
	//���ڡ��������������
	public List<News> getContantNews(int ntid);
	//��ҳ
	public List<News> getNewsPageSize1(int ntid,int pageNum);
	
	public void addNews(News news);
	public void deleteNews(News news);
	public void updateNewsTitle(News news);
	
}
