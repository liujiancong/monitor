package com.gmcc.monitor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class JdbcTest {
	
	@Test
	public void testJdbc() throws ClassNotFoundException {
		 Connection conn = null;
		 Statement stmt  = null;
	        String sql;
	       String url = "jdbc:mysql://192.168.242.128:3306/zqmonitor?useUnicode=true&serverTimezone=UTC&characterEncoding=UTF8";
	        //String url = "jdbc:mysql://10.247.138.224:3306/zqgzl?useUnicode=true&serverTimezone=UTC&characterEncoding=UTF-8";
	 
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");// 动态加载mysql驱动
	            System.out.println("成功加载MySQL驱动程序");
	            conn = DriverManager.getConnection(url, "zq_monitor", "zq_monitor");
	            stmt = conn.createStatement();
	            sql = "select * from tb_system";
	            ResultSet result = stmt.executeQuery(sql);
	            System.out.println(result);
	        }catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					stmt.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	}

}
