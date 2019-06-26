package com.care.controller;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;



//JUnit 4.0으로 현재 클래스를 실행시킴
@RunWith(SpringJUnit4ClassRunner.class)
//mybatis에서 참조하는 설정파일의 위치를 알려줌
@WebAppConfiguration
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class MainControllerTest {
	// 로깅 처리를 위한 코드
	private static final Logger logger = LoggerFactory.getLogger(MainControllerTest.class);
		
	// @Autowired
	@Inject // 의존관계 주입(스프링에서 객체를 생성하여 전달)
	WebApplicationContext wac;
	MockMvc mockMvc; // 가상으로 컨트롤러를 테스트하기 위한 객체
	
	@Before // 테스트 전에 호출되는 코드
	public void setup() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		System.out.println("setup...");
	}
		
	//JUnit이 테스트하는 코드
	@Test
	public void testDoA() throws Exception {
		// 뷰가 완성되지 않은 상태에서도 테스트가 가능함
		mockMvc.perform(MockMvcRequestBuilders.get("/test/doA"));
		logger.info("doA...");
	}

}
