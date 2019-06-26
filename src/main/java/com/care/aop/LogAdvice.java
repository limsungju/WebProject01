package com.care.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component // 스프링에서 관리하는 bean
@Aspect // 스프링에서 관리하는 aop bean
public class LogAdvice {
	private static final Logger logger = LoggerFactory.getLogger(LogAdvice.class);
	
	// 포인트컷 - 실행 시점, Around - 실행 전후
	// before, after, Around
	// 컨트롤러, 서비스, dao의 모든 method 실행 전후에 logPrint method가 호출됨
	// execution( 리턴자료형 class.method(매개변수) )
	
	  @Around( "execution(* com.care.controller..*Controller.*(..))" +
	  " or execution(* com.care.service..*Impl.*(..))" +
	  " or execution(* com.care.model.dao..*Impl.*(..))")
	 
	public Object logPrint(ProceedingJoinPoint joinPoint) throws Throwable {
		// 요청 전에 처리할 코드
		long start = System.currentTimeMillis();
		// 메인 코드(핵심업무, 종단관심)
		Object result = joinPoint.proceed(); // 핵심업무 실행 joinPoint.proceed() => 호출 전 후를 나눠준다.
		// 메인 코드가 끝난 후에 처리할 코드
		// 핵심업무를 실행한 클래스와 method의 정보 확인
		// 호출한 클래스 이름
		String type = joinPoint.getSignature().getDeclaringTypeName();
		String name = "";
		if(type.indexOf("Controller") > -1) {
			name="Controller \t:";
		} else if(type.indexOf("Service") > -1) {
			name = "ServiceImpl \t:";
		} else if(type.indexOf("DAO") > -1) {
			name = "DaoImpl \t:";
		}
		// 호출한 클래스, method 정보
		logger.info(name+type+"."+joinPoint.getSignature().getName()+"()");
		// method에 전달되는 매개변수들
		logger.info(Arrays.deepToString(joinPoint.getArgs()));
		// 핵심로직으로 이동
		long end = System.currentTimeMillis();
		long time = end-start;
		logger.info("실행시간:" + time);
		return result;
	}
}
