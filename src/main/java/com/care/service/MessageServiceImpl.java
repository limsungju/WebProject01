package com.care.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.care.model.dao.MessageDAO;
import com.care.model.dao.PointDAO;
import com.care.model.dto.MessageDTO;

@Service
public class MessageServiceImpl implements MessageService {
	
	@Inject
	MessageDAO messageDao;
	
	@Inject
	PointDAO pointDao;
	
	@Transactional // method 내부의 코드를 트랜잭션 (거리처리 단위)으로 묶음
	@Override
	public void addMessage(MessageDTO dto) {
		messageDao.create(dto);
		pointDao.updatePoint(dto.getSender(), 10);
	}

	@Override
	public MessageDTO readMessage(String userid, int mid) {
		
		return null;
	}

}
