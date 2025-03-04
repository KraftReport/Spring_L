package com.test.base;

import org.springframework.stereotype.Component;

@Component
public class HelloBean {

	public void sayHello() {
		System.out.println("hello ioc container");
	}
	
}
