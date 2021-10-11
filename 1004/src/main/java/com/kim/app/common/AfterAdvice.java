package com.kim.app.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterAdvice {
	// 에스펙트(실시간 위빙처리)
	// 어드바이스+포인트컷
	
//	@Pointcut("execution(* model.board.*Impl.select*(..))")
//	public void aPointcut() {}
//	@Pointcut("execution(* model.board.*Impl.*(..))")
//	public void bPointcut() {}
	
	@After("PointcutCommon.bPointcut()")
	public void printLog(JoinPoint jp) {
		Object[] args=jp.getArgs();
		String name=jp.getSignature().getName();
		
		System.out.println("메서드명: "+name);
		System.out.println("메서드변수정보: "+args);
		System.out.println("핵심관심 후에 호출됨After");
	}
}
