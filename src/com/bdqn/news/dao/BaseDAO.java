package com.bdqn.news.dao;

/**
 * ���ݿ����ӻ��࣬���ã��������ݿ�Ͳ�ѯ���������
 * @���ݲ�
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bdqn.news.util.ConfigManager;

public class BaseDAO {
	
	//�������ļ�����ȡ��������Ϣ��ֵ
	private String Driver = ConfigManager.getInstance().getString("jdbc.driver.class");
	private String URL = ConfigManager.getInstance().getString("jdbc.connection.url");
	private String USERNAME = ConfigManager.getInstance().getString("jdbc.connection.username");
	private String PASSWORD = ConfigManager.getInstance().getString("jdbc.connection.password");
	
	protected Connection conn;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	
	//���ݿ����ӷ���
	public Connection getConnection() {
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//���ӡ�ɾ�������Ĵ�����
	public int executeUpdate(String sql,Object[] params){
		//����һ������������Ӱ�����
		int updateRows = 0;
		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			for(int i = 0; i < params.length;i++){
				pstmt.setObject(i+1, params[i]);
			}
			//���շ���ֵ
			updateRows = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updateRows;
	}
	
	//���ݿ��ѯ���ؽ��������
	//�����е�"Object[] params"��������������ݿ��ѯ��� sql �еı���ֵ(��˵�е�ռλ��)
	public ResultSet getResultSet(String sql,Object[] params){
		try {
			conn=this.getConnection();
			pstmt = conn.prepareStatement(sql);
			//��� sql ����еı���ֵ
			for(int i = 0; i < params.length; i++){
				pstmt.setObject(i+1, params[i]);
			}
			rs=pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
		}
	
	//���ݿ���Դ�ͷŵķ���
	public void closeResoure(ResultSet rs,PreparedStatement pstmt,Connection conn){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
