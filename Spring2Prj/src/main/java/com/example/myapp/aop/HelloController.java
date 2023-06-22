package com.example.myapp.aop;

import lombok.Setter;

@Setter
public class HelloController {
	
	IHelloService helloService;
	

	public void hello(String name) {
		String result = helloService.sayHello(name);
		System.out.println(result);
	}
}
