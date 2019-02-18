package org.dxh.pattern.factory;

import org.dxh.pattern.factory.Shape.Shape;

/**
 * Use this Simple factory in order to get object
 * 使用该简单工厂，通过传递类型信息来获取实体类的对象。
 * シンプルファクトリを使って、入力データにより、対象を取得する
 * 
 * @author xiaohujapan
 * @since 8.0
 */
public class SimpleFactoryPatternDemo {
 
   public static void main(String[] args) {
      SimpleShapeFactory shapeFactory = new SimpleShapeFactory();
 
      Shape shape1 = shapeFactory.getShape("CIRCLE");
      shape1.draw();
 
      Shape shape2 = shapeFactory.getShape("RECTANGLE");
      shape2.draw();
 
      Shape shape3 = shapeFactory.getShape("SQUARE");
      shape3.draw();
   }
}