package com.example.myapp.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloMain {
	public static void main(String[] args) {
		AbstractApplicationContext context = 
					new AnnotationConfigApplicationContext(AppConfig.class);
//					new GenericXmlApplicationContext("application-config.xml");
		System.out.println("===============================");
		HelloController controller = context.getBean(HelloController.class);
		//같은 타입의 bean을 두개이상 만들 수 있음==> 있을 경우에는 HelloController.class로 하면안됨
		//어떠한 bean을 쓸 줄 모르기때문에 오류
		controller.hello("홍길동");
		System.out.println("===============================");
		context.close();
		
	}
}
