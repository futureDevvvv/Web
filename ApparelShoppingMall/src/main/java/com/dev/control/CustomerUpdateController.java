package com.dev.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dev.service.CustomerService;
import com.dev.vo.CustomerVO;

public class CustomerUpdateController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.getQueryString();

		HttpSession session = req.getSession();
		
		String id = (String) session.getAttribute("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		
		CustomerVO vo = new CustomerVO();
		vo.setPw(pw);
		vo.setName(name);
		vo.setEmail(email);
		
		CustomerService service = new CustomerService();
		
		req.setAttribute("rpw", pw);
		req.setAttribute("rname", name);
		req.setAttribute("rmail", email);
		
		req.getRequestDispatcher("Customer/mypage.jsp").forward(req, res);
	}

}
