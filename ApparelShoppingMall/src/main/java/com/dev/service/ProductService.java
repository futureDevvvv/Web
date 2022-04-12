package com.dev.service;

import java.util.List;

import com.dev.dao.ProductDAO;
import com.dev.vo.ProductVO;

public class ProductService {
	ProductDAO dao = new ProductDAO();
	
	public List<ProductVO> searchAll(){
		return dao.productList();
	}
	
	public ProductVO insert(ProductVO vo) {
		return dao.productInsert(vo);
	}
}
