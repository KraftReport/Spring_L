package com.test.base;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanTest {

	@Test
	void testOne() {
		try(var context = new AnnotationConfigApplicationContext()){
			context.scan("com.test");
			context.refresh();
			var bean = context.getBean("haha"); 
			var wow = context.getBean(WowBean.class);
			wow.wow();
			assertEquals(wow, bean);
		}
	}
}
