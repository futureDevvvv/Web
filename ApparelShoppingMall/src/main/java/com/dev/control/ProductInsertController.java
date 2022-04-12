package com.dev.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.service.ProductService;
import com.dev.vo.ProductVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ProductInsertController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getQueryString();
		
		ServletContext context = req.getServletContext();
		String savePath = context.getRealPath("upload");
		int maxSize = 1024 * 1024 * 30;
		String encoding = "UTF-8";
		MultipartRequest mRequest = new MultipartRequest(req, savePath, maxSize, encoding, new DefaultFileRenamePolicy());
	
		String pid = mRequest.getParameter("p_id");
		String pname = mRequest.getParameter("p_name");
		String pprice = mRequest.getParameter("p_price");
		String pinfo = mRequest.getParameter("p_info");
		String pimage = mRequest.getFilesystemName("p_image");
		
		ProductVO vo = new ProductVO();
		vo.setpId(pid);
		vo.setpName(pname);
		vo.setpPrice(Integer.parseInt(pprice));
		vo.setpInfo(pinfo);
		vo.setpImage(pimage);
		
		ProductService service = new ProductService();
		service.insert(vo);
		
		List<ProductVO> list = service.searchAll();
		
		req.setAttribute("productList", list);
		
		req.getRequestDispatcher("productList.jsp").forward(req, res);
		
	}

}
