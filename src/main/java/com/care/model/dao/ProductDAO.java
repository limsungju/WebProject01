package com.care.model.dao;

import java.util.List;

import com.care.model.dto.ProductDTO;

// 상품관리
public interface ProductDAO {
	List<ProductDTO> listProduct(); // 상품 목록
	ProductDTO detailProduct(int product_id); // 상품 상세정보
	void updateProduct(ProductDTO dto); // 상품정보 수정
	void deleteProduct(int product_id); // 상품정보 삭제
	void insertProduct(ProductDTO dto); // 상품정보 추가
	String fileInfo(int product_id); // 파일 정보
}
