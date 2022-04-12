package com.dev.service;

import java.util.List;

import com.dev.dao.BoardDAO;
import com.dev.vo.BoardVO;

public class BoardService {
	BoardDAO dao = new BoardDAO();
	
	//전체 리스트 조회
	public List<BoardVO> selectAll(){
		return dao.selectAll();
	}

	//게시글 하나 조회
	public BoardVO selectOne(int b_id) {
		// TODO Auto-generated method stub
		return dao.selectOne(b_id);
	}

	//게시글 입력
	public BoardVO insert(BoardVO vo) {
		return dao.boardInsert(vo);
	}
}
