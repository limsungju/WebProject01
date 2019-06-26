package com.care.model.dao;

import com.care.model.dto.MessageDTO;

public interface MessageDAO {
	public void create(MessageDTO dto); // 메시지 생성
	public MessageDTO readMessage(int mid); // 메시지 읽기
	public void updateState(int mid); // 상태 변경
}
