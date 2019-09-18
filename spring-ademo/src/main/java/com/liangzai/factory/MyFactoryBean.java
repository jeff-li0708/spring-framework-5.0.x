package com.liangzai.factory;

import com.liangzai.handler.MyInvocationHandler;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

/**
 * Created by liangl on 2019/9/18.
 */
public class MyFactoryBean implements FactoryBean {

	Class mappingInterface;

	@Override
	public Object getObject() throws Exception {
		return Proxy.newProxyInstance(mappingInterface.getClassLoader(),new Class[]{mappingInterface},new MyInvocationHandler());
	}

	@Override
	public Class<?> getObjectType() {
		return mappingInterface;
	}
}
