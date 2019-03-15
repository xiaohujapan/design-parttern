3.step3-为bean注入属性
这一步，我们想要为bean注入属性。我们选择将属性注入信息保存成PropertyValue对象，并且保存到BeanDefinition中。这样在初始化bean的时候，我们就可以根据PropertyValue来进行bean属性的注入。Spring本身使用了setter来进行注入，这里为了代码简洁，我们使用Field的形式来注入。

// 1.　初始化beanfactory
BeanFactory beanFactory = new AutowireCapableBeanFactory();

// 2.bean定义
BeanDefinition beanDefinition = new BeanDefinition();
beanDefinition.setBeanClassName("us.codecraft.tinyioc.HelloWorldService");

// 3.　设置属性
PropertyValues propertyValues = new PropertyValues();
propertyValues.addPropertyValue(new PropertyValue("text", "Hello World!"));
beanDefinition.setPropertyValues(propertyValues);

// 4.　生成bean
beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

// 5.　获取bean
HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
helloWorldService.helloWorld();