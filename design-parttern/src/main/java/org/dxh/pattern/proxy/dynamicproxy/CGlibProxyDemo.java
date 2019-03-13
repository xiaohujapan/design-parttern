package org.dxh.pattern.proxy.dynamicproxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 
 * CGLIB 采用了非常底层的字节码技术，其原理是通过字节码技术为一个类创建子类，并在子类中采用方法拦截的技术拦截所有父类方法的调用，
 * 　顺势织入横切逻辑。但因为采用的是继承，所以不能对final修饰的类进行代理。
 * 
 * 使用 CGLIB 需要实现 MethodInterceptor 接口，并重写intercept 方法，
 * 在该方法中对原始要执行的方法前后做增强处理。
 * 　该类的代理对象可以使用代码中的字节码增强器来获取。
 *
 */
public class CGlibProxyDemo implements MethodInterceptor {
    private Object proxy;

    public Object getInstance(Object proxy) {
        this.proxy = proxy;
        // Enhancer类是CGLIB中的一个字节码增强器，它可以方便的对你想要处理的类进行扩展
        Enhancer enhancer = new Enhancer();
        // 将被代理的对象设置成父类
        enhancer.setSuperclass(this.proxy.getClass());
        // 回调方法，设置拦截器
        enhancer.setCallback(this);
        // 动态创建一个代理类
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
