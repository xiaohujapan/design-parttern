package org.dxh.java.basespring.tinyioc.step4;

import java.util.Map;
import java.util.Set;

import org.dxh.java.basespring.tinyioc.step3.BeanDefinition;
import org.dxh.java.basespring.tinyioc.step4.io.ResourceLoader;
import org.dxh.java.basespring.tinyioc.step4.xml.XmlBeanDefinitionReader;

public class XmlBeanDefinitionReaderTest {

	public static void main(String[] args)throws Exception {
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
		xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc-test.xml");
		Map<String, BeanDefinition> registry = xmlBeanDefinitionReader.getRegistry();
		Set<String> keys= registry.keySet();
		for(String key:keys) {
			System.out.println(registry.get(key));
		}
	}

}
