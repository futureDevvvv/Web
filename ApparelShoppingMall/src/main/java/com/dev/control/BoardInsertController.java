package com.dev.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dev.service.BoardService;
import com.dev.vo.BoardVO;

public class BoardInsertController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getQueryString();

		HttpSession session = req.getSession();
		
		String id = (String) session.getAttribute("id");
		String title = req.getParameter("title");
		String content = req.getParameter("content");

		BoardVO vo = new BoardVO();

		vo.setId(id);
		vo.setB_title(title);
		vo.setB_content(content);

		BoardService service = new BoardService();
		service.insert(vo);

		req.setAttribute("board", vo);
		req.getRequestDispatcher("Board/BoardOutput.jsp").forward(req, res);

	}

}
