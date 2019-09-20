package com.ademo.test;

import com.liangzai.config.AppConfig;
import com.liangzai.bean.User;
import com.liangzai.dao.UserDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by liangl on 2019/9/5.
 */
public class BaseTest {


	public static void main(String[] args) {

		//通过Java代码方式创建应用上下文
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(); //
		applicationContext.register(AppConfig.class);
		applicationContext.refresh();

		//获取通过注解Bean注册的对象
		User user = (User) applicationContext.getBean("user");//首次调用getBean才会创建对象
		System.out.println(user.getName());

		//获取接口对象
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");

		System.out.println(userDao.query());
	}


}
