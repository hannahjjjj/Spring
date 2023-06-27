package com.example.myapp.aop;

import lombok.Setter;

@Setter
public class HelloController {
	
	IHelloService helloService;
	

	public void hello(String name) {
		System.out.println("HelloController " + helloService.sayHello(name));
	}
	
	public void goodbye(String name) {
		System.out.println("HelloController " + helloService.sayGoodbye(name));
	}
}
