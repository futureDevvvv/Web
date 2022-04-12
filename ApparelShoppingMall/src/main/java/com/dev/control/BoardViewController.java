package com.dev.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.service.BoardService;
import com.dev.vo.BoardVO;

public class BoardViewController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int b_id = Integer.parseInt(req.getParameter("b_id"));
		
		/*String id = req.getParameter("id");
		String title = req.getParameter("title");
		String Content = req.getParameter("content");*/

		BoardService service = new BoardService();

		BoardVO vo = service.selectOne(b_id);
		
		req.setAttribute("board", vo);
		req.getRequestDispatcher("Board/BoardView.jsp").forward(req, res);
	}
}
