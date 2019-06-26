package com.care.model.dao;

import java.util.List;

import com.care.model.dto.CartDTO;

// 장바구니 관리
public interface CartDAO {
	List<CartDTO> cartMoney();
	void insert(CartDTO dto); // 장바구니에 담기
	List<CartDTO> listCart(String userid); // 장바구니 목록
	void delete(int cart_id); // 장바구니 개별 삭제
	void deleteAll(String userid); // 장바구니 비우기
	void update(int cart_id);
	int sumMoney(String userid); // 장바구니 금액 합계
	int countCart(String userid, int product_id); // 장바구니 상품 갯수
	void updateCart(CartDTO dto); // 장바구니 수정
	void modifyCart(CartDTO dto);
}
