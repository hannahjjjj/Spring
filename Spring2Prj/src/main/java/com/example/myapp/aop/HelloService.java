package com.example.myapp.aop;

import org.springframework.stereotype.Service;

@Service
public class HelloService implements IHelloService{
	@Override
	public String sayHello(String name) {
//		HelloLog.log(); //횡단관점<-AOP는 이것도 없애자.
		return "Hello~~" + name;
	}
	@Override
	public String sayGoodBye(String name) {
		return "GoodBye~~"+name;
	}
}
