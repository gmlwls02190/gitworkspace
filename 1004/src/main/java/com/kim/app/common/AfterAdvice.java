package com.kim.app.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterAdvice {
	// ������Ʈ(�ǽð� ����ó��)
	// �����̽�+����Ʈ��
	
//	@Pointcut("execution(* model.board.*Impl.select*(..))")
//	public void aPointcut() {}
//	@Pointcut("execution(* model.board.*Impl.*(..))")
//	public void bPointcut() {}
	
	@After("PointcutCommon.bPointcut()")
	public void printLog(JoinPoint jp) {
		Object[] args=jp.getArgs();
		String name=jp.getSignature().getName();
		
		System.out.println("�޼����: "+name);
		System.out.println("�޼��庯������: "+args);
		System.out.println("�ٽɰ��� �Ŀ� ȣ���After");
	}
}
