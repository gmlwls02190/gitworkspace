package com.kim.app.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class TimeAdvice {
	
	@Around("PointcutCommon.bPointCut()")
	public Object printLog(ProceedingJoinPoint pjp) throws Throwable {
		StopWatch sw=new StopWatch();
		
		sw.start();
		Object obj=pjp.proceed();
		sw.stop();
		
		System.out.println("메서드 수행시간: "+sw.getTotalTimeMillis()+"ms");
		return obj;
	}
}
