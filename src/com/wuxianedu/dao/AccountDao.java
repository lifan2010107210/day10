package com.wuxianedu.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;



import com.wuxianedu.util.JdbcUtil_C3P0;
import com.wuxianedu.util.JdbcUtil_Dbcp;


public class AccountDao {
	@Test
	public void find() throws SQLException{
		Connection connection = JdbcUtil_Dbcp.getConnection();
	   PreparedStatement statement = connection.prepareStatement("select * from account where id=1");
	   ResultSet resultSet = statement.executeQuery();
	   while (resultSet.next()) {
		   System.out.println(resultSet.getInt("id"));
		   System.out.println(resultSet.getString("name"));
	  }
	}
	
	
	@Test
	public void find2() throws SQLException{
		Connection connection = JdbcUtil_C3P0.getConnection();
	   PreparedStatement statement = connection.prepareStatement("select * from account where id=1");
	   ResultSet resultSet = statement.executeQuery();
	   while (resultSet.next()) {
		   System.out.println(resultSet.getInt("id"));
		   System.out.println(resultSet.getString("name"));
	   }
	}
}