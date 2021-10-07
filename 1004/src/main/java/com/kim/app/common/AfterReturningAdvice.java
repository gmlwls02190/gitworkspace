package com.kim.app.common;

import org.aspectj.lang.JoinPoint;

import model.member.TestMemVO;

public class AfterReturningAdvice {
	public void printLog(JoinPoint jp,Object obj) {
		String name=jp.getSignature().getName();
		System.out.println("�޼����: "+name);
		if(obj instanceof TestMemVO) {
			TestMemVO data=(TestMemVO)obj;
			if(data.getRole().equals("ADMIN")) {
				System.out.println("������ �α���");
			}
			else {
				System.out.println("�Ϲݻ���� �α���");
			}			
		}
		System.out.println("get()�� ���յǴ� returning");
	}
}
