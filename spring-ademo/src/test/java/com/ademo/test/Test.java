package com.ademo.test;

import com.liangzai.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by liangl on 2019/9/5.
 */
public class Test {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(AppConfig.class);
		//applicationContext.getBean()
	}
}
