package org.dxh.pattern.builder;

import org.dxh.pattern.builder.pack.Packing;

/**
 * Create An interface In order to item
 * 创建一个表示食物条目的接口。
 * 食べ物のインターフェースを作成する
 * 
 * @author xiaohujapan
 * @since 8.0
 */
public interface Item {
	 public String name();
	 public Packing packing();
	 public float price();    
}
