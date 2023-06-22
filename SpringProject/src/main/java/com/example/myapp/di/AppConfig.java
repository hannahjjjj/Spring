package com.example.myapp.di;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;


@Configurable//bean설정 파일로 쓰인다
@ComponentScan(basePackages= {"com.example.myapp"}) //어노테이션도 지원할거다
//기존의 xml도 할거면 @ImportResource이거 쓰면 됨
@ImportResource(value= {"classpath:application-config.xml"})
public class AppConfig {
	//자바설정파일을 이용한 의존성 주입
	
	@Bean
	public IHelloService helloService() {
		//다른 코드를 포함할 수 있음
		return new HelloService();
	}
	
	@Bean
	public HelloController helloController() {
//		return new HelloController(); 바로 리턴하면안됨.set메서드 불러와야하니깐
		HelloController controller = new HelloController();
		controller.setHelloService(helloService());
		return controller;
	}

}
