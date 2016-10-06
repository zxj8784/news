package com.bdqn.news.dao;

/**
 * ��Ӧ���ݱ��е� news ��(�ӿ�)
 * �淶д����ҵ���ͨ�����ݲ�ӿڼ�ӵ������ݿ���н���
 * @���ݲ�
 */
import java.util.List;

import com.bdqn.news.entity.News;

public interface NewsDAO {
	
	public List<News> getNewsTitle();
	//��ҳ��ѯ���ݿ�����ݣ�ÿ����"pageSize"�����ݷ�����һҳ��
	public List<News> getNewsPageSize(int ntid);
	public List<News> getNewsPageSize1(int ntid,int pageNum,int pageSize);
	public void addNews(News news);
	public void deleteNews(News news);
	public void updateNewsTitle(News news);
}
