package com.eternal.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
	private static Connection conn = null;
	private static PreparedStatement ps = null;
	private static CallableStatement cs = null;
	private static String driver = "";
	private static String url = "";
	private static String userName = "";
	private static String password = "";
	private static Properties pp = null;
	private static FileInputStream fis = null;

	// 加载驱动，只需要一次
	static {
		try {
			// 从配置文件mysql.properties中读取配置信息
			pp = new Properties();
			fis = new FileInputStream(DBUtil.class.getClassLoader().getResource("db.properties").getPath());
			pp.load(fis);
			driver = pp.getProperty("driver");
			url = pp.getProperty("url");
			userName = pp.getProperty("user");
			password = pp.getProperty("password");

			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fis != null)
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			fis = null;

		}
	}

	// 得到连接
	public static Connection getConnection() {
		if (conn != null) {
			return conn;
		}
		try {
			conn = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//关闭数据库连接方法
	public static void closeAll(ResultSet rs,Statement stmt,Connection conn){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {			
				e.printStackTrace();
			}
		}
		if(stmt!=null){
			try {
				stmt.close();
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
	//执行sql语句，返回值n
	public static  int executeUpdate(String sql,Object[] params){
		Connection conn  = null;
		PreparedStatement pstmt = null;
		int  n = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			for(int i = 0;i<params.length;i++){
				pstmt.setObject(i+1, params[i]);
			}
			n = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeAll(null,pstmt,null);
		}
		return n;
		
	}
	
	// select
		public static ResultSet executeQuery(String sql, String...parameters) {
			try {
				conn = getConnection();
				ps = conn.prepareStatement(sql);
				if (parameters != null) {
					for (int i = 0; i < parameters.length; i++) {
						ps.setString(i + 1, parameters[i]);
					}
				}
				return ps.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e.getMessage());
			}
		}

		// 调用无返回值存储过程
		// 格式： call procedureName(parameters list)
		public static void callProc(String sql, String...parameters) {
			try {
				conn = getConnection();
				cs = conn.prepareCall(sql);
				// 给？赋值
				if (parameters != null) {
					for (int i = 0; i < parameters.length; i++)
						cs.setObject(i + 1, parameters[i]);
				}
				cs.execute();
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
}
