4.step4-读取xml配置来初始化bean
这么大一坨初始化代码让人心烦。这里的BeanDefinition只是一些配置，我们还是用xml来初始化吧。我们定义了BeanDefinitionReader初始化bean，它有一个实现是XmlBeanDefinitionReader。

// 1.　读取配置
XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");

// 2.　初始化BeanFactory并注册bean
BeanFactory beanFactory = new AutowireCapableBeanFactory();
for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
        beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
}

// 3.　获取bean
HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
helloWorldService.helloWorld();