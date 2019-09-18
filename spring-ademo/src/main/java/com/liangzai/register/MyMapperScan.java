package com.liangzai.register;

import org.springframework.context.annotation.Import;

/**
 * Created by liangl on 2019/9/18.
 */
@Import(MyImportBeanDefinitionRegister.class)
public @interface MyMapperScan {

	String[] value() default {};
}
