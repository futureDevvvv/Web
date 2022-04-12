package com.dev.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.service.BoardService;
import com.dev.vo.BoardVO;

public class BoardListController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		BoardService service = new BoardService();
		List<BoardVO> list = service.selectAll();
		
		req.setAttribute("boardList", list);
		req.getRequestDispatcher("Board/BoardMain.jsp").forward(req, res);
	}
}
