package com.kim.app.common;

import org.aspectj.lang.JoinPoint;

public class AfterAdvice {
	public void printLog(JoinPoint jp) {
		Object[] args=jp.getArgs();
		String name=jp.getSignature().getName();
		
		System.out.println("�޼����: "+name);
		System.out.println("�޼��庯������: "+args);
		System.out.println("�ٽɰ��� �Ŀ� ȣ���After");
	}
}
