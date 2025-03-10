package com.test.base;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.test.util.MyBean;

@MyBean("haha")
@Scope("singleton")
@Lazy
public class WowBean {

	public void wow() {
		System.out.println("just wow");
	}
}
