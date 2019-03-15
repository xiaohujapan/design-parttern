2.step2-将bean创建放入工厂
step1中的bean是初始化好之后再set进去的，实际使用中，我们希望容器来管理bean的创建。于是我们将bean的初始化放入BeanFactory中。为了保证扩展性，我们使用Extract Interface的方法，将BeanFactory替换成接口，而使用AbstractBeanFactory和AutowireCapableBeanFactory作为其实现。"AutowireCapable"的意思是“可自动装配的”，为我们后面注入属性做准备。

 // 1.　初始化beanfactory
BeanFactory beanFactory = new AutowireCapableBeanFactory();

// 2.　注入bean
BeanDefinition beanDefinition = new BeanDefinition();
beanDefinition.setBeanClassName("us.codecraft.tinyioc.HelloWorldService");
beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

// 3.　获取bean
HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
helloWorldService.helloWorld();