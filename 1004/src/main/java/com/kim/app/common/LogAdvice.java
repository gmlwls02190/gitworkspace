package com.kim.app.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LogAdvice {
	
	@Before("PointcutCommon.aPointcut()")
	public void printLog() {
		System.out.println("비즈니스 메서드를 수행하기 전에 출력되는 로그!");
		// 응집도가 높다!
	}
}
