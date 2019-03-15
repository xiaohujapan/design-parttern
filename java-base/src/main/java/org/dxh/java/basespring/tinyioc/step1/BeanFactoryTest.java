package org.dxh.java.basespring.tinyioc.step1;

public class BeanFactoryTest {

	public static void main(String[] args) {
		// 1.初始化beanfactory
		BeanFactory beanFactory = new BeanFactory();
		
		// 2.注入bean
		BeanDefinition beanDefinition = new BeanDefinition(new HelloWorldService());
		beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);;
		
		
		 // 3.获取bean
		HelloWorldService helloWorldService = (HelloWorldService)beanFactory.getBean("helloWorldService");
		helloWorldService.helloworld();
	}

}
