package com.care.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.model.dto.CartDTO;
import com.care.service.CartService;

@Controller
@RequestMapping("/shop/cart/*")
public class CartController {
	
	@Inject
	CartService cartService;
	
	// 장바구니에 목록 추가
	@RequestMapping("insert.do")
	public String insert(@ModelAttribute CartDTO dto, HttpSession session) {
		// 로그인 여부를 체크하기 위해 세션에 저장된 아이디 확인
		String userid = (String)session.getAttribute("userid");
		if(userid==null) { // 로그인하지 않은 상태면 로그인 화면으로 이동
			return "redirect:/member/login.do";
		}
		dto.setUserid(userid);
		cartService.insert(dto); // 장바구니 테이블에 저장됨
		return "redirect:/shop/cart/list.do"; // 장바구니 목록으로 이동
	}
	
	// 장바구니 리스트
	@RequestMapping("list.do")
	public String list(HttpSession session, Model model) {
		Map<String, Object> map = new HashMap<>();
		String userid = (String)session.getAttribute("userid");
		//if(userid != null) { // 로그인한 상태
			List<CartDTO> list = cartService.listCart(userid); // 장바구니 목록
			int sumMoney = cartService.sumMoney(userid); // 금액 합계
			map.put("sumMoney", sumMoney); // 전체 금액
			map.put("list", list); // 장바구니 목록
			map.put("count", list.size()); // 레코드 개수
			model.addAttribute("map", map); // 데이터 저장
			return "shop/cart_list";
		/*} else { // 로그인하지 않은 상태
			return "member/login";
		}*/
	}
	
	// 장바구니 선태 항목 지우기
	@RequestMapping("delete.do")
	public String delete(@RequestParam int cart_id) {
		cartService.delete(cart_id);
		return "redirect:/shop/cart/list.do";
	}
	
	// 장바구니 비우기
	@RequestMapping("deleteAll.do")
	public String deleteAll(HttpSession session) {
		String userid = (String)session.getAttribute("userid");
		if(userid != null) {
			cartService.deleteAll(userid);
		}
		return "redirect:/shop/cart/list.do";
	}
	
	// 장바구니 수량 수정하기
	@RequestMapping("update.do")
	// 똑같은 이름의 태그가 여러개 넘어오면 받는곳에서는 배열로 받아야한다.
	public String update(int[] amount, int[] cart_id, HttpSession session) {
		String userid=(String) session.getAttribute("userid");
		for(int i=0; i<cart_id.length; i++) {
			if(amount[i]==0) { // 수량이 0개이면 삭제하기
				cartService.delete(cart_id[i]);
			} else { // 수량이 1개 이상이면
				CartDTO dto = new CartDTO();
				dto.setUserid(userid);
				dto.setCart_id(cart_id[i]);
				dto.setAmount(amount[i]);
				cartService.modifyCart(dto);
			}
		}
		return "redirect:/shop/cart/list.do";
	}
}
