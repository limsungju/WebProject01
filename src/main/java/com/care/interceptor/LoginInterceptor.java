package com.care.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	// 선처리
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 세션 객체 생성
		HttpSession session = request.getSession();
		// 세션 변수 검사
		if(session.getAttribute("userid") == null) {
			// 세션이 없으면 로그인 페이지로 이동
			response.sendRedirect(request.getContextPath()+"/member/login.do?message=nologin");
			return false; // 메인 액션으로 가지 않음
		} else {
		return true; // 메인 액션으로 이동
	}
  }
	
}
