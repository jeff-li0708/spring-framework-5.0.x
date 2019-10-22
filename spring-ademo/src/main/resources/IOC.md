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
			
spring获取实例对象过程
org.springframework.context.support.AbstractApplicationContext.getBean(java.lang.String)
    org.springframework.beans.factory.support.AbstractBeanFactory.getBean(java.lang.String)
        org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean
 

spring实例化所有单例对象（非lazy-init）        
1.org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons                   
2.    org.springframework.beans.factory.support.AbstractBeanFactory.getBean(java.lang.String)                     
3.        org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean 
4.          org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(java.lang.String, org.springframework.beans.factory.ObjectFactory<?>) 
5.              org.springframework.beans.factory.ObjectFactory.getObject 
6.                  org.springframework.beans.factory.support.AbstractBeanFactory.createBean
7.          org.springframework.beans.factory.support.AbstractBeanFactory.createBean
8.              org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.resolveBeforeInstantiation
9.              org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean
    
1.遍历beanDefinitionNames依次调用getBean(beanName)创建beanName对应的实例,遍历时判断是否是抽象类、是否单例、是否非LazyInit，
对于是FactoryBean的类，在调用getBean(beanName)前会在beanName前加&前缀
2.调用doGetBean(name, null, null, false)方法
3.转换beanName(别名转换等)，尝试从单例对象缓冲池中获取实例，能获取到，则根据返回的sharedInstance和name获取实际的对象，若sharedInstance是FactoryBean，则检查是否返回FactoryBean.getObject()返回的对象
没获取到，首先看是否有父BeanFactory且当前beanFactory的beanDefinitionMap中不存在对应的beanDefinition，有则通过parentBeanFactory.getBean()方法获取实例对象。
无则继续后面的处理,首先标记bean正在创建或者即将被创建，看是否有依赖对象，有则先实例化依赖对象，然后再通过bean的作用域选择不同的创建对象策略
4.对于单例会调用getSingleton方法，首先尝试从单例对象缓冲池中获取实例，获取到则直接返回,没获取到，没获取到会调用第二个入参的getObject()方法,最终会调到AbstractBeanFactory.createBean(beanName, mbd, args)
5.getObject()方法会返回AbstractBeanFactory.createBean()创建的对象
7.多例以及其他作用域的类最终也是调AbstractBeanFactory.createBean()创建的对象,这个方法首先会克隆一个RootBeanDefinition,



			
			
			
			



