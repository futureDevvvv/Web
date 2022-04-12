package com.dev.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dev.vo.BoardVO;

public class BoardDAO extends DAO {

	// 게시물 전체 출력
	public List<BoardVO> selectAll() {
		String sql = "select * from board order by b_id desc";
		List<BoardVO> list = new ArrayList<BoardVO>();
		connect();

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				BoardVO vo = new BoardVO();

				vo.setB_id(rs.getInt("b_id"));
				vo.setId(rs.getString("m_id"));
				vo.setB_title(rs.getString("b_title"));
				vo.setB_date(rs.getDate("b_date"));

				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 게시물 단건 조회
	public BoardVO selectOne(int b_id) {
		String sql = "select * from board where b_id = ?";
		connect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, b_id);
			rs = psmt.executeQuery();

			if (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setB_id(rs.getInt(b_id));
				vo.setId(rs.getString("id"));
				vo.setB_title(rs.getString("title"));
				vo.setB_content(rs.getString("content"));
				vo.setB_date(rs.getDate("b_date"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;

	}

	// 글 입력
	public BoardVO boardInsert(BoardVO vo) {
		String sql = "insert into board values(b_seq.nextval,?,?,?,sysdate)";

		connect();

		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getB_title());
			psmt.setString(3, vo.getB_content());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력 완료되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}

	// 글 수정
	public int update(BoardVO vo) {
		return 0;
	}

	// 글 삭제
	public int delete(int b_id) {
		return 0;
	}

}
