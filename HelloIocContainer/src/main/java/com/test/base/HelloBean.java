package com.test.base;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.test.util.MyBean;

@Component
@Lazy
@Scope("prototype")
public class HelloBean {

	public void sayHello() {
		System.out.println("hello ioc container");
	}
	
}
