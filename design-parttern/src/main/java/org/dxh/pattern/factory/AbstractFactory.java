package org.dxh.pattern.factory;

import org.dxh.pattern.factory.Shape.Shape;
import org.dxh.pattern.factory.color.Color;

/**
 * This abstract Class In Order to get Color,shape's factory
 * 为 Color 和 Shape 对象创建抽象类来获取工厂。
 * 抽象クラスは色と形の対象を抽出するため
 * 
 * @author xiaohujapan
 * @since 8.0
 */
public abstract class AbstractFactory {
	public abstract Color getColor(String color);
	public abstract Shape getShape(String shape);
}
