package org.dxh.pattern.factorymethod;

/**
 * A simple sample factory class
 * 一个简单的工厂类
 * 簡単なファクトリクラス
 * 
 * @author xiaohujapan
 * @since 8.0
 */
public class SimpleShapeFactory {
	public Shape getShape(String shapeType){
	   if(shapeType == null){
	       return null;
	    }        
	    if(shapeType.equalsIgnoreCase("CIRCLE")){
	       return new Circle();
	    } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
	       return new Rectangle();
	    } else if(shapeType.equalsIgnoreCase("SQUARE")){
	       return new Square();
	    }
	    return null;
	}
}
