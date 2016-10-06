package com.bdqn.news.dao;

/**
 * 数据库连接基类，作用：连接数据库和查询结果处理函数
 * @数据层
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bdqn.news.util.ConfigManager;

public class BaseDAO {
	
	//从配置文件类中取得配置信息的值
	private String Driver = ConfigManager.getInstance().getString("jdbc.driver.class");
	private String URL = ConfigManager.getInstance().getString("jdbc.connection.url");
	private String USERNAME = ConfigManager.getInstance().getString("jdbc.connection.username");
	private String PASSWORD = ConfigManager.getInstance().getString("jdbc.connection.password");
	
	protected Connection conn;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	
	//数据库连接方法
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
	
	//增加、删除、更改处理方法
	public int executeUpdate(String sql,Object[] params){
		//定义一个变量接收受影响的行
		int updateRows = 0;
		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			for(int i = 0; i < params.length;i++){
				pstmt.setObject(i+1, params[i]);
			}
			//接收返回值
			updateRows = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updateRows;
	}
	
	//数据库查询返回结果集方法
	//方法中的"Object[] params"参数代表的是数据库查询语句 sql 中的变量值(传说中的占位符)
	public ResultSet getResultSet(String sql,Object[] params){
		try {
			conn=this.getConnection();
			pstmt = conn.prepareStatement(sql);
			//填充 sql 语句中的变量值
			for(int i = 0; i < params.length; i++){
				pstmt.setObject(i+1, params[i]);
			}
			rs=pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
		}
	
	//数据库资源释放的方法
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
