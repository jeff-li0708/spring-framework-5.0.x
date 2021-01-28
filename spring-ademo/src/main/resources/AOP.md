AspectJAutoProxyBeanDefinitionParser
AnnotationAwareAspectJAutoProxyCreator
AbstractAutoProxyCreator

事务的执行过程
org.springframework.transaction.interceptor.TransactionInterceptor.invoke
    org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction
        org.springframework.transaction.interceptor.TransactionAspectSupport.createTransactionIfNecessary --创建事务
            org.springframework.transaction.support.AbstractPlatformTransactionManager.getTransaction
                org.springframework.jdbc.datasource.DataSourceTransactionManager.doGetTransaction
              