package org.dxh.pattern.factory.color;

/**
 * This Class is implement Shape,In Order to implement draw method
 * 创建实现接口的实体类。
 * インターフェイスを利用し、drawメソッドを実現する
 * 
 * @author xiaohujapan
 * @since 8.0
 */
public class Blue implements Color {

	@Override
	public void fill() {
		System.out.println("Inside Green::fill() method.");
	}

}
