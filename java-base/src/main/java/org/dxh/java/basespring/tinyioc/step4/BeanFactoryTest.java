package org.dxh.java.basespring.tinyioc.step4;

import java.util.Map;

import org.dxh.java.basespring.tinyioc.step3.BeanDefinition;
import org.dxh.java.basespring.tinyioc.step3.HelloWorldService;
import org.dxh.java.basespring.tinyioc.step3.factory.AutowireCapableBeanFactory;
import org.dxh.java.basespring.tinyioc.step3.factory.BeanFactory;
import org.dxh.java.basespring.tinyioc.step4.io.ResourceLoader;
import org.dxh.java.basespring.tinyioc.step4.xml.XmlBeanDefinitionReader;

public class BeanFactoryTest {

	public static void main(String[] args)throws Exception {
		// 1.读取配置
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
		xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc-test.xml");
		
		// 2.初始化BeanFactory并注册bean
		BeanFactory beanFactory = new AutowireCapableBeanFactory();
		for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
			beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
		}
		
		// 3.获取bean
		HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
		helloWorldService.helloWorld();

	}

}
