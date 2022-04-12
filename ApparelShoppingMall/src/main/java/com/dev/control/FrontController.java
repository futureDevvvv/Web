package com.dev.control;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet{
	HashMap<String, Controller> list = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException{
	System.out.println("controller init()");
	
	list = new HashMap<String, Controller>();
	
	//회원관련
	list.put("/CustomerInsert.do", new CustomerInsertController()); //회원가입
	list.put("/CustomerUpdate.do", new CustomerUpdateController()); //마이페이지
	
	//제품관련
	list.put("/productList.do", new ProductListController());
	list.put("/productPut.do", new ProductPutController());
	list.put("/product/productInsert.do", new ProductInsertController());
	
	//게시판
	list.put("/BoardMain.do", new BoardListController());
	list.put("/BoardView.do", new BoardViewController());
	list.put("/BoardInsert.do", new BoardInsertController());
	
	//로그인
	list.put("/login.do", new LoginController());
	list.put("/logout.do", new LogoutController());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String url = req.getRequestURI(); // http://localhost:80/P20211208/memberInsert.do
		//System.out.println(url);
		String context = req.getContextPath(); // 위에 값을 읽어오기 위해서 context를 찾아오고 / memberinsert~~를 키값으로 찾아옴
		//System.out.println(context);
		String path = url.substring(context.length());
		System.out.println(path);
		
		Controller subCont = list.get(path);
		//System.out.println(req);
		//System.out.println(res);
		//System.out.println(subCont);
		System.out.println(subCont);
		subCont.execute(req, res);
	}
}
