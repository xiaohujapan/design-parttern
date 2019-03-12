package org.dxh.pattern.proxy.reflectproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class FruitProxy implements InvocationHandler {
	
	private Object targetObj;
	
	public Object bind(Object targetObj) {
		this.targetObj = targetObj;
		return Proxy.newProxyInstance(targetObj.getClass().getClassLoader(), targetObj.getClass().getInterfaces(), this);
	}

	//自定义invoke方法
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println(">>>>>before invoking");
		//真正调用方法的地方
		Object result = method.invoke(this.targetObj, args);
		System.out.println(">>>>after invoking");
		return result;
	}

}
