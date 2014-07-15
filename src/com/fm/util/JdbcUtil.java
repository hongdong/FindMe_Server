package com.fm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * jdbc封装类
 * 
 * @author caizhi 2014-04-27 1.0
 * 
 */
public class JdbcUtil {
	/**
	 * 获得驱动
	 * 
	 */
	private static String DRIVER = PropertiesUtil.JDBC_DRIVER;
	/**
	 * 获得url
	 * 
	 */
	private static String URL = PropertiesUtil.JDBC_URL;
	/**
	 * 获得连接数据库的用户名
	 * 
	 */
	private static String USER = PropertiesUtil.JDBC_USER;
	/**
	 * 获得连接数据库的密码
	 * 
	 */
	private static String PASS = PropertiesUtil.JDBC_PASS;
	// 连接对象
	// private Connection connection;;

	static {
		try {
			// 利用类加载器读取配置文件
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 该方法获得连接
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASS);
	}

	// 释放资源
	public static void close(Connection conn, Statement st, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {

				e.printStackTrace();
			} finally {
				if (st != null) {
					try {
						st.close();
					} catch (SQLException e) {

						e.printStackTrace();
					} finally {
						if (conn != null) {
							try {
								conn.close();
							} catch (SQLException e) {

								e.printStackTrace();
							}
						}
					}
				}
			}

		}

	}

}
