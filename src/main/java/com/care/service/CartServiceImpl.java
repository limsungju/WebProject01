package com.care.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.care.model.dao.CartDAO;
import com.care.model.dto.CartDTO;

@Service
public class CartServiceImpl implements CartService {
	
	@Inject
	CartDAO cartDao;
	
	@Override
	public List<CartDTO> cartMoney() {
		
		return cartDao.listCart("userid");
	}

	@Override
	public void insert(CartDTO dto) {
		cartDao.insert(dto);
	}

	@Override
	public List<CartDTO> listCart(String userid) {
		
		return cartDao.listCart(userid);
	}

	@Override
	public void delete(int cart_id) {
		cartDao.delete(cart_id);
		
	}

	@Override
	public void deleteAll(String userid) {
		cartDao.deleteAll(userid);
		
	}

	@Override
	public void update(int cart_id) {
		
		
	}

	@Override
	public int sumMoney(String userid) {
		return cartDao.sumMoney(userid);
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
		cartDao.modifyCart(dto);
		
	}

}
