package org.dxh.java.basespring.tinyioc.step2.factory;

import org.dxh.java.basespring.tinyioc.step2.BeanDefinition;

public interface BeanFactory {
    Object getBean(String name);

    void registerBeanDefinition(String name, BeanDefinition beanDefinition);
}
