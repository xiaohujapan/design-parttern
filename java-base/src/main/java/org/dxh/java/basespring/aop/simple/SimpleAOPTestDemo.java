package org.dxh.java.basespring.aop.simple;

public class SimpleAOPTestDemo {

	public static void main(String[] args) {
		// 1. 创建一个 MethodInvocation 实现类
		MethodInvocation logTask = new MethodInvocationImpl();
		HelloWorld helloServiceImpl = new HelloWorldImpl();	
		 // 2. 创建一个 Advice
		 Advice beforeAdvice = new BeforeAdvice(helloServiceImpl, logTask);
		 
		// 3. 为目标对象生成代理
		 HelloWorld helloServiceImplProxy = (HelloWorld) SimpleAOP.getProxy(helloServiceImpl,beforeAdvice);
		 helloServiceImplProxy.sayHelloWorld();
	}

}
