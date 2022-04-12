package com.dev.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.dev.service.CustomerService;
import com.dev.vo.CustomerVO;

public class LoginController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
	
		System.out.println(id);
		System.out.println(pw);
		CustomerService service = new CustomerService();
		int loginResult = service.login(id, pw);

		System.out.println(service.login(id, pw));

		HttpSession session = req.getSession();

		if (loginResult == 1) {
			// index.jsp
			req.setAttribute("loginResult", loginResult);
			session.setAttribute("id", id);
			req.getRequestDispatcher("index.jsp").forward(req, res);
			
		} else {
			// login.jsp
			req.setAttribute("loginResult", loginResult);
			req.getRequestDispatcher("login.jsp").forward(req, res);
			
		}
	}
}
