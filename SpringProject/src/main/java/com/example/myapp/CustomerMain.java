package com.example.myapp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CustomerMain {
	
	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new GenericXmlApplicationContext("application-config.xml");
		Customer cust = context.getBean(Customer.class);
		System.out.println(cust);
		Customer cust2 = context.getBean(Customer.class);
		System.out.println(cust == cust2);
		context.close();
	}
}
