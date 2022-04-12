package com.dev.dao;

import java.sql.SQLException;

import com.dev.vo.CustomerVO;

public class CustomerDAO extends DAO {

	//입력(회원가입)
	public CustomerVO customerInsert(CustomerVO vo) {
		String sql = "insert into customer values(?,?,?,?)";

		connect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPw());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getEmail());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}
	
	//아이디 중복 여부 체크
	public static boolean idCheck(String id) {
		String sql = "select id from customer";
		
		connect();
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				if(rs.getString("id").equals(id)) {
					return true;
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	//수정
	public CustomerVO customerUpdate(CustomerVO vo) {
		String sql = "update customer set name=? pw=? email=? where id =?";
		connect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPw());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getEmail());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;

	}
	
	//로그인 체크
	public int loginCheck(String id, String pw) {
		String sql = "select * from customer where id=? and pw=?";
		
		connect();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				CustomerVO vo = new CustomerVO();
				if(rs.getString("pw").equals(pw)) {
					return 1;
				} else {
					return 0;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return -1;
	}
	
}
