package com.care.model.dao;

import java.util.List;

import com.care.model.dto.MemberDTO;

// 회원정보 관리
public interface MemberDAO {
	public List<MemberDTO> memberList();
	public void insertMember(MemberDTO vo);
	public MemberDTO viewMember(String userid);
	public void deleteMember(String userid);
	public void updateMember(MemberDTO vo);
	public boolean checkPw(String userid, String passwd);
	public String loginCheck(MemberDTO dto);
}
