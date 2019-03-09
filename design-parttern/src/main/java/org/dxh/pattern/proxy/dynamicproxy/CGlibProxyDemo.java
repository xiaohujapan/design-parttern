package org.dxh.pattern.proxy.dynamicproxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CGlibProxyDemo implements MethodInterceptor {
    private Object proxy;

    public Object getInstance(Object proxy) {
        this.proxy = proxy;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.proxy.getClass());
        // 回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }

    //回调方法
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		//在代理真实对象前我们可以添加一些自己的操作
		System.out.println("before rent house");
		System.out.println("Method:" + method);
		
		//当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用
		proxy.invokeSuper(obj, args);
		
		 //在代理真实对象后我们也可以添加一些自己的操作
		System.out.println("after rent house");
		return null;
	}

	public static void main(String[] args) {
		CGlibProxyDemo cGlibProxyDemo = new CGlibProxyDemo();
		// 我们要代理的真实对象
		RealSubject realSubject = (RealSubject)cGlibProxyDemo.getInstance(new RealSubject());
		realSubject.rent();
		realSubject.hello("world");

	}

}
