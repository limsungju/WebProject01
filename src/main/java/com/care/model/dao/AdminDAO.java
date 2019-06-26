package com.care.model.dao;

import com.care.model.dto.MemberDTO;

// 관리자 관리
public interface AdminDAO {
	public String loginCheck(MemberDTO dto);
}
