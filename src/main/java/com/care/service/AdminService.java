package com.care.service;

import com.care.model.dto.MemberDTO;

// 관리자 관리
public interface AdminService {
	public String loginCheck(MemberDTO dto);
}
