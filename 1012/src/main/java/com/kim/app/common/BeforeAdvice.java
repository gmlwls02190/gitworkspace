package com.kim.app.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class BeforeAdvice {
	@Before("PointcutCommon.aPointcut()")
	public void printLog() {
		System.out.println("데이터 출력이 시작됩니다!");
	}
}
