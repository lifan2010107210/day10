package com.wuxianedu.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class JdbcUtil_Dbcp {

	
	static DataSource dataSource = null;
	static{
		Properties properties = new Properties();
		try {
			properties.load(JdbcUtil_Dbcp.class.getClassLoader().getResourceAsStream("dbcpconfig.properties"));
			
			BasicDataSourceFactory factory = new BasicDataSourceFactory();
			dataSource = factory.createDataSource(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static Connection getConnection() throws SQLException{
	
		return dataSource.getConnection();
	}

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