package com.care.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.care.model.dto.ProductDTO;

// 컨트롤러 어노테이션(컨트롤러 객체를 자동으로 생성)
@Controller
public class MainController {
	// 로그 객체 생성
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	// 시작 페이지로 이동
	@RequestMapping("/") // url pattern mapping
	public String main(Model model) {
		// Model : 데이터를 담는 그릇 역할, map 구조로 저장됨
		// model.addAttribute("변수명", 값)
		// model.addAttribute("message", "홈페이지 방문을 환영합니다.");
		// <beans:property name="prefix" value="/WEB-INF/views/" />
		// <beans:property name="suffix" value=".jsp" />
		// /WEB-INF/views/main.jsp
		return "main"; // main.jsp로 포워딩됨
	}
}
