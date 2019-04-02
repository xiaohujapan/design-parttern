package org.dxh.java.basespring.tinyioc.step5;

/**
 * 从配置中读取BeanDefinitionReader
 * @author yihua.huang@dianping.com
 */
public interface BeanDefinitionReader {

    void loadBeanDefinitions(String location) throws Exception;
}

