package com.care.model.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.care.model.dto.CartDTO;


// 장바구니 관리
@Repository
public class CartDAOImpl implements CartDAO {
	
	@Inject
	SqlSession sqlSession;
	//상품별 장바구니 금액 통계
	@Override
	public List<CartDTO> cartMoney() {
		
		return sqlSession.selectList("cart.cart_money"); 
	}
	
	@Override
	public void insert(CartDTO dto) {
		sqlSession.insert("cart.insert", dto);
		
	}
	
	//장바구니 목록
	@Override
	public List<CartDTO> listCart(String userid) {
		
		return sqlSession.selectList("cart.listCart", userid);
	}
	
	//장바구니 개별 상품 삭제
	@Override
	public void delete(int cart_id) {
		sqlSession.delete("cart.delete", cart_id);
		
	}
	
	//장바구니 비우기
	@Override
	public void deleteAll(String userid) {
		sqlSession.delete("cart.deleteAll", userid);
		
	}

	@Override
	public void update(int cart_id) {
		
		
	}

	@Override
	public int sumMoney(String userid) {
		return sqlSession.selectOne("cart.sumMoney", userid);
	}

	@Override
	public int countCart(String userid, int product_id) {
		
		return 0;
	}

	@Override
	public void updateCart(CartDTO dto) {
		
		
	}

	@Override
	public void modifyCart(CartDTO dto) {
		sqlSession.update("cart.modify", dto);
		
	}

}
