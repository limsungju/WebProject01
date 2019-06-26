package com.care.service;

import com.care.model.dto.MessageDTO;

public interface MessageService {
	public void addMessage(MessageDTO dto); // 메세지 추가
	public MessageDTO readMessage(String userid, int mid); // 메세지 읽기
}
