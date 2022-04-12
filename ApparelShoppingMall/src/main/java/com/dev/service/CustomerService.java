package com.dev.service;

import com.dev.dao.CustomerDAO;
import com.dev.vo.CustomerVO;

public class CustomerService {
	CustomerDAO dao = new CustomerDAO();
	
	//회원 등록(회원가입)
	public CustomerVO insert(CustomerVO vo) {
		return dao.customerInsert(vo);
	}
	
	//회원정보 수정(마이페이지)
	public CustomerVO update(CustomerVO vo) {
		return dao.customerUpdate(vo);
	}
	
	//로그인
	public int login(String id, String pw) {
		return dao.loginCheck(id, pw);
	}
}

