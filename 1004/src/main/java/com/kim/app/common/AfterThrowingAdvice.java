package com.kim.app.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;

public class AfterThrowingAdvice {
	@AfterThrowing(pointcut="?Pointcut",throwing="excep")
	public void printLog(JoinPoint jp,Exception excep) {
		String name=jp.getSignature().getName();
		System.out.println("메서드명: "+name);
		System.out.println("예외: "+excep);
		
		if(excep instanceof IllegalArgumentException) {
			System.out.println("매개변수로 적절하지 않습니다!");
			System.out.println("1. id가 PK인데 0 or 이미존재하는값으로 처리했는지 확인");
		}
		else if(excep instanceof ArithmeticException){
			System.out.println("0으로 나눌수없습니다!");
			System.out.println("1. /0했는지 확인");
		}
		else if(excep instanceof Exception) {
			System.out.println("미확인 예외입니다!");
		}
		
		System.out.println("예외발생시 호출됨Throwing");
	}
}
