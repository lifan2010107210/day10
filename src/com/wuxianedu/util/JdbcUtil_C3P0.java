package com.wuxianedu.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtil_C3P0 {

	
	static DataSource dataSource = null;
	static{
		dataSource = new ComboPooledDataSource();
	}
	
	/**
	 * 获取链接
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		//拿到connection dataSource 不同对象有不同方法
		return dataSource.getConnection();
	}
	/**
	 * 释放资源
	 */
	public static void release(ResultSet resultSet,Statement statement,Connection connection){
		if(resultSet!=null){
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(statement!=null){
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(connection!=null){
			try {
				
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}