package com.kim.app.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutCommon {
	
	@Pointcut("execution(* model..*Impl.select*(..))")
	public void aPointCut() {}
	
	@Pointcut("execution(* model..*Impl.*(..))")
	public void bPointCut() {}
}
