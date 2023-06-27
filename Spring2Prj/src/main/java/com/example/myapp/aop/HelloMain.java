package com.example.myapp.aop;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloMain {
	public static void main(String[] args) {
		AbstractApplicationContext context = 
					new GenericXmlApplicationContext("application-config.xml");
		System.out.println("===============================");
		HelloController controller = context.getBean(HelloController.class);
		controller.hello("홍길동");
		System.out.println("===============================");
		controller.goodbye("이순신");
		System.out.println("===============================");
		context.close();
		
	}
}
