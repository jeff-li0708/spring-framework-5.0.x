package com.liangzai.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by liangl on 2019/9/18.
 */
public class MyInvocationHandler implements InvocationHandler {
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//1.连接数据库

		//2.执行sql
		System.out.println("---------执行sql---------");
		return "success";
	}
}
