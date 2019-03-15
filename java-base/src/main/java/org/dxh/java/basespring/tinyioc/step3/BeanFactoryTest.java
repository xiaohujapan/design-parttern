package org.dxh.java.basespring.tinyioc.step3;

import org.dxh.java.basespring.tinyioc.step3.HelloWorldService;
import org.dxh.java.basespring.tinyioc.step3.factory.AutowireCapableBeanFactory;
import org.dxh.java.basespring.tinyioc.step3.factory.BeanFactory;

public class BeanFactoryTest {

	public static void main(String[] args)throws Exception {
		// 1.初始化beanfactory
		BeanFactory beanFactory = new AutowireCapableBeanFactory();
		
		// 2.bean定义
		BeanDefinition beanDefinition = new BeanDefinition();
		beanDefinition.setBeanClassName("org.dxh.java.basespring.tinyioc.step3.HelloWorldService");
		
		// 3.设置属性
		PropertyValues propertyValues = new PropertyValues();
		propertyValues.addPropertyValue(new PropertyValue("text", " Hello World!!"));
        beanDefinition.setPropertyValues(propertyValues);
        
		// 4.生成bean
        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);
        
		// 5.获取bean
		HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
		helloWorldService.helloWorld();
	}

}
