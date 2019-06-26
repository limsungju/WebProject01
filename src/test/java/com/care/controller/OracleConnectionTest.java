package com.care.controller;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OracleConnectionTest {
	private static final Logger logger = LoggerFactory.getLogger(OracleConnectionTest.class);
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521/xe";
	private static final String USER = "spring";
	private static final String PW = "1234";
	
	@Test
	public void testConnection() throws Exception {
		Class.forName(DRIVER);
		// try ~ with (java 1.7이상 사용 가능)
		// 괄호안에 명세시 실행종료후 자동으로 close됨
		try(Connection conn = DriverManager.getConnection(URL, USER, PW)) {
			System.out.println("오라클에 연결되었습니다.");
			logger.info("오라클에 연결되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
