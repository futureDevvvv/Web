package com.dev.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DAO {
	public static Connection conn;
	public Statement stmt;
	public static PreparedStatement psmt;
	public static ResultSet rs;

	public static void connect() {
		try {
			/*
			 * Class.forName("oracle.jdbc.driver.OracleDriver"); //2. DB 서버 접속하기 / 연결상태를
			 * 받아오면 컨넥션으로 관리 String url = "jdbc:oracle:thin:@localhost:1521:xe"; String id
			 * ="hr"; String password = "hr"; conn = DriverManager.getConnection(url, id,
			 * password);
			 */

			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/myoracle");
			conn = ds.getConnection();
			System.out.println("연결성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void disconnect() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (psmt != null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
