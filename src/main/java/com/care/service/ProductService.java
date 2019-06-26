package com.care.service;

import java.util.List;

import com.care.model.dto.ProductDTO;

// 상품정보 관리
public interface ProductService {
	public List<ProductDTO> listProduct();
	public ProductDTO detailProduct(int product_id);
	public String fileInfo(int product_id);
	public void updateProduct(ProductDTO dto);
	public void deleteProduct(int product_id);
	public void insertProduct(ProductDTO dto);
}
