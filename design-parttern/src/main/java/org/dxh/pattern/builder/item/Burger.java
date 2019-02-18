package org.dxh.pattern.builder.item;

import org.dxh.pattern.builder.pack.Packing;
import org.dxh.pattern.builder.pack.Wrapper;

/**
 * This abstract Class In Order to get Burger's factory
 * 为对象创建抽象类来获取工厂。
 * 抽象クラスは対象を抽出するため
 * 
 * @author xiaohujapan
 * @since 8.0
 */
public abstract class Burger implements Item {
	@Override
	public Packing packing() {
		return new Wrapper();
	}

	@Override
	public abstract float price();
}
