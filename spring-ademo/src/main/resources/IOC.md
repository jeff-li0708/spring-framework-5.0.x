1.BeanDefinition -- java bean在Spring中的描述类,它有三个实现类，分别是RootBeanDefinition、ChildBeanDefinitio、
GenericDefinition,他们都继承AbstractBeanDefinition,下面会详细介绍他们的作用和区别

AbstractBeanDefinition提取了所有子类的公共属性和方法


spring中BeanDefinition的注册
org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext#AnnotationConfigServletWebServerApplicationContext()
	org.springframework.context.annotation.AnnotatedBeanDefinitionReader#AnnotatedBeanDefinitionReader(org.springframework.beans.factory.support.BeanDefinitionRegistry)
		org.springframework.context.annotation.AnnotatedBeanDefinitionReader#AnnotatedBeanDefinitionReader(org.springframework.beans.factory.support.BeanDefinitionRegistry, org.springframework.core.env.Environment)
			org.springframework.context.annotation.AnnotationConfigUtils#registerAnnotationConfigProcessors(org.springframework.beans.factory.support.BeanDefinitionRegistry)
				org.springframework.context.annotation.AnnotationConfigUtils#registerAnnotationConfigProcessors
					org.springframework.context.annotation.AnnotationConfigUtils#registerPostProcessor
						org.springframework.context.support.GenericApplicationContext#registerBeanDefinition
							org.springframework.beans.factory.support.DefaultListableBeanFactory#registerBeanDefinition


spring单例对象缓冲池注册调用过程
org.springframework.context.support.AbstractApplicationContext#refresh
	org.springframework.context.support.AbstractApplicationContext#prepareBeanFactory
		org.springframework.beans.factory.support.DefaultListableBeanFactory#registerSingleton
			org.springframework.beans.factory.support.DefaultSingletonBeanRegistry#registerSingleton
			
			
			
			



