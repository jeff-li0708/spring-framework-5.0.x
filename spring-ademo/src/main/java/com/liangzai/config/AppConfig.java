package com.liangzai.config;

import com.liangzai.bean.User;
import com.liangzai.register.MyMapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by liangl on 2019/9/9.
 */
@Configuration
@MyMapperScan("com.liangzai.dao") //使用注解的话，应在MyImportBeanDefinitionRegister获取注解的配置，然后扫描包下面的所有Dao接口
//@Import(MyImportBeanDefinitionRegister.class) //使用注解Import导入指定的类到spring容器
@ComponentScan("com.liangzai.service") //扫描所有service
@EnableAspectJAutoProxy
public class AppConfig {

	/**
	 * 通过Bean方式向spring容器注入对象
	 * @return
	 */
	@Bean("user")
	public User getUser(){
		return new User();
	}


}
