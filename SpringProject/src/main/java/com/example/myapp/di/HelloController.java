package com.example.myapp.di;

import lombok.Setter;

@Setter
public class HelloController {
	
//	@Autowired //autowired만 쓰일때는 변수명으로 bean찾음
//	@Qualifier("niceService") //bean 2개이상일 때 지정해서 쓰고싶을 때 사용
	
	IHelloService helloService;
	
	

	public void hello(String name) {
		System.out.println("실행결과 : " + helloService.sayHello(name));
	}
}
