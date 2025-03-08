package com.test.base;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.test.AppConfig;

public class HelloTest {

	@Test
	void testOne() {
		try (var context = new AnnotationConfigApplicationContext(AppConfig.class)) { 
			var dateBean = context.getBean(Date.class);
			System.out.println(dateBean.toString());
			var helloBean = context.getBean(HelloBean.class);
			helloBean.sayHello();
		}
	}
	
	@Test
	void testTwo() {
		try(var context = new GenericXmlApplicationContext()){
			context.load("classpath:bean.xml");
			context.refresh();
			var bean = context.getBean(HelloBean.class);
			bean.sayHello();
		}
	}

}
