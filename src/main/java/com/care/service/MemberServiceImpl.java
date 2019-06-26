package com.care.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.care.model.dao.MemberDAO;
import com.care.model.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject // 스프링 컨테이너가 만든 dao 객체가 연결됨(의존관계 주입)
	MemberDAO memberDao;
	
	@Override
	public List<MemberDTO> memberList() {
		return memberDao.memberList();
	}
	
	@Override
	public void insertMember(MemberDTO dto) {
		memberDao.insertMember(dto);
	}

	@Override
	public MemberDTO viewMember(String userid) {
		return memberDao.viewMember(userid);
	}

	@Override
	public void deleteMember(String userid) {
		memberDao.deleteMember(userid);
		
	}

	@Override
	public void updateMember(MemberDTO dto) {
		memberDao.updateMember(dto);
		
	}

	@Override
	public boolean checkPw(String userid, String passwd) {
		return memberDao.checkPw(userid, passwd);
	}

	@Override
	public String loginCheck(MemberDTO dto, HttpSession session) {
		// 맞으면 이름이 넘어오고 틀리면 null이 넘어옴
		String name=memberDao.loginCheck(dto);
		
		if(name != null) { // 맞으면
			// 세션변수 등록 기본 15분
			session.setAttribute("userid", dto.getUserid());
			session.setAttribute("name", name);
		}
		return name;
	}

	@Override
	public void logout(HttpSession session) {
		//세션을 모두 초기화시킴
		session.invalidate();
		
	}
}
