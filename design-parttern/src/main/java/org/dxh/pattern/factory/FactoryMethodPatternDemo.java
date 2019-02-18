package org.dxh.pattern.factory;

/**
 * Use this factory method in order to get object
 * 使用该工厂方法，通过传递类型信息来获取实体类的对象。
 * ファクトリメソッドを使って、入力データにより、対象を取得する
 * 
 * @author xiaohujapan
 * @since 8.0
 */
public class FactoryMethodPatternDemo {
 
   public static void main(String[] args)throws Exception{
	   /**
	   ShapeFactory circleFactory = new CircleFactory();
	   circleFactory.getShape().draw();
	   **/
	   ShapeFactory circleFactory = (ShapeFactory)Class.forName("org.dxh.pattern.factorymethod.CircleFactory").newInstance();
	   circleFactory.getShape().draw();
	   
	   ShapeFactory rectangleFactory = (ShapeFactory)Class.forName("org.dxh.pattern.factorymethod.RectangleFactory").newInstance();
	   rectangleFactory.getShape().draw();
	   
	   ShapeFactory squareFactory = (ShapeFactory)Class.forName("org.dxh.pattern.factorymethod.SquareFactory").newInstance();
	   squareFactory.getShape().draw();
   }
}