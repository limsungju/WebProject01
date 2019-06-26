package com.care.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.care.model.dto.MemberDTO;
import com.care.service.AdminService;

// 관리자 페이지 관리
@Controller
@RequestMapping("/admin/*")
public class AdminController {
	
	@Inject
	AdminService adminService;
	
	// 관리자 로그인
	@RequestMapping("login.do")
	public String login() {
		return "admin/login";
	}
	
	// 관리자 로그인 체크
	@RequestMapping("login_check.do")
	public String login_check(MemberDTO dto, HttpSession session, Model model) {
		String name = adminService.loginCheck(dto);
		//if(name != null) { // 로그인 성공
			session.setAttribute("admin_userid", dto.getUserid());
			session.setAttribute("admin_name", name);
			session.setAttribute("userid", dto.getUserid());
			session.setAttribute("name", name);
			model.addAttribute("message", "success");
			return "admin/admin";
		//} else {
		//	model.addAttribute("message", "error");
		//	return "admin/login";
		//}
	}
	
	// 관리자 로그아웃 처리
	@RequestMapping("logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/admin/login.do";
	}
}
