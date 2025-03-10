package com.test.base;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
	
	@Test
	void testTwo() {
		try(var context = new AnnotationConfigApplicationContext()){
			context.scan("com.test");
			context.refresh();
			var hello1 = context.getBean(HelloBean.class);
			var wow1 = context.getBean(WowBean.class);
			var hello2 = context.getBean(HelloBean.class);
			var wow2 = context.getBean(WowBean.class);
			assertTrue(hello1 != hello2);
			assertTrue(wow1 == wow2);
		}
	}
}
