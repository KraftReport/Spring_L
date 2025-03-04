package com.test.base;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloTest {

	@Test
	void testOne() {
		try (var context = new GenericXmlApplicationContext()) {
			context.load("classpath:bean.xml");
			context.refresh(); 
			var helloBean = context.getBean(HelloBean.class);
			helloBean.sayHello();
		}
	}

}
