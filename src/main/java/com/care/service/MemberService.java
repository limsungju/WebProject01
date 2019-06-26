package com.care.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.care.model.dto.MemberDTO;

// 회원정보 관리
public interface MemberService {
	public List<MemberDTO> memberList();
	public void insertMember(MemberDTO dto);
	public MemberDTO viewMember(String userid);
	public void deleteMember(String userid);
	public void updateMember(MemberDTO dto);
	public boolean checkPw(String userid, String passwd); // 비밀번호 체크
	public String loginCheck(MemberDTO dto, HttpSession session);
	public void logout(HttpSession session);
}
