package com.care.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.care.model.dao.AdminDAO;
import com.care.model.dto.MemberDTO;

// 관리자 관리
@Service
public class AdminServiceImpl implements AdminService {
	
	@Inject
	AdminDAO adminDao;
	
	@Override
	public String loginCheck(MemberDTO dto) {
		return adminDao.loginCheck(dto);
	}

}
