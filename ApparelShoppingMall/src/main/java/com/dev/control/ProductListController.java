package com.dev.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.service.ProductService;
import com.dev.vo.ProductVO;

public class ProductListController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ProductService service = new ProductService();
		List<ProductVO> list = service.searchAll();
		
		req.setAttribute("productList", list);
		req.getRequestDispatcher("product/productList.jsp").forward(req, res);
	}

}
