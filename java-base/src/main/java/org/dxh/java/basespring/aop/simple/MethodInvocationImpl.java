package org.dxh.java.basespring.aop.simple;

public class MethodInvocationImpl implements MethodInvocation {

	@Override
	public void invoke() {
		 System.out.println("log task start");
	}

}
