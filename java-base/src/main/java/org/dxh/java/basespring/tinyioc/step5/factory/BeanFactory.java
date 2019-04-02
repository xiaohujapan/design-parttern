package org.dxh.java.basespring.tinyioc.step5.factory;

import org.dxh.java.basespring.tinyioc.step5.BeanDefinition;

/**
 * bean的容器
 * @author yihua.huang@dianping.com
 */
public interface BeanFactory {

    Object getBean(String name) throws Exception;

    void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception;
}
