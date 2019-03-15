package org.dxh.java.basespring.tinyioc.step2.factory;

import org.dxh.java.basespring.tinyioc.step1.HelloWorldService;
import org.dxh.java.basespring.tinyioc.step2.BeanDefinition;

public class BeanFactoryTest {

	public static void main(String[] args) {
		// 1.初始化beanfactory
		BeanFactory beanFactory = new AutowireCapableBeanFactory();
		
		// 2.注入bean
		BeanDefinition beanDefinition = new BeanDefinition();
		beanDefinition.setBeanClassName("org.dxh.java.basespring.tinyioc.step1.HelloWorldService");
		beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);
		
		//3.获取bean
		HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
		helloWorldService.helloworld();
	}

}
