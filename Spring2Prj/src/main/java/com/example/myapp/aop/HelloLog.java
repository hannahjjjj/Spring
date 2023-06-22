package com.example.myapp.aop;


import java.lang.reflect.Modifier;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

public class HelloLog {
	public static void log(JoinPoint joinPoint) {
		System.out.println(">>>Log<<<" + new java.util.Date());
		Signature s = joinPoint.getSignature();
		System.out.println("핵심코드 메서드이름: " + s.getName());
		System.out.println("메서드가 선언된 곳: " + s.getDeclaringTypeName());
		System.out.println("제한자: " + s.getModifiers());
		System.out.println("제한자: " + Modifier.toString(s.getModifiers()));
	
	}
}
