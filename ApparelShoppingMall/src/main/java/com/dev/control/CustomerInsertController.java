package com.dev.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.service.CustomerService;
import com.dev.vo.CustomerVO;

public class CustomerInsertController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		req.getQueryString();
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		
		CustomerVO vo = new CustomerVO();
		vo.setId(id);
		vo.setPw(pw);
		vo.setName(name);
		vo.setEmail(email);
		
		CustomerService service = new CustomerService();
		service.insert(vo);
		
		req.setAttribute("customer", vo);
		req.getRequestDispatcher("Customer/Signup.jsp").forward(req, res);
	}
}
