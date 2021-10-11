package com.kim.app.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutCommon {
	
	// ���� �޼���
	// �����̽��� ����Ʈ���� "�ĺ�"�ϱ����� �ۼ�
	// ������ �ۼ����ʿ�xxx {}�ٵ���� �������
	@Pointcut("execution(* model.board.*Impl.select*(..))")
	public void aPointcut() {}
	
	@Pointcut("execution(* model.board.*Impl.*(..))")
	public void bPointcut() {}
	
	@Pointcut("execution(* model.member.*Impl.select*(..))")
	public void cPointcut() {}
	
}
