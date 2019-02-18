package org.dxh.pattern.builder.pack;

/**
 * This Class is implement Shape,In Order to implement pack method
 * 创建实现接口的实体类。
 * インターフェイスを利用し、packメソッドを実現する
 * 
 * @author xiaohujapan
 * @since 8.0
 */
public class Bottle implements Packing {

	@Override
	public String pack() {
		return "Wrapper";
	}

}
