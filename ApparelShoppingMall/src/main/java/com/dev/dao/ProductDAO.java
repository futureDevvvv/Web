package com.dev.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dev.vo.ProductVO;

public class ProductDAO extends DAO{
	
	// 상품 리스트
	public List<ProductVO> productList(){
		List<ProductVO> list = new ArrayList<>();
		
		String sql = "select * from product order by 1";
		connect();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setpId(rs.getString("p_id"));
				vo.setpName(rs.getString("p_name"));
				vo.setpPrice(rs.getInt("p_price"));
				vo.setpInfo(rs.getString("p_info"));
				vo.setpImage(rs.getString("p_image"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	public ProductVO productInsert(ProductVO vo) {
		String sql = "insert into product values(?,?,?,?,?)";
		connect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getpId());
			psmt.setString(2, vo.getpName());
			psmt.setInt(3, vo.getpPrice());
			psmt.setString(4, vo.getpInfo());
			psmt.setString(5, vo.getpImage());
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}
}
