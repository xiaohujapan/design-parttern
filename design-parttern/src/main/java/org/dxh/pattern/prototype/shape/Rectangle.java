package org.dxh.pattern.prototype.shape;

import org.dxh.pattern.prototype.Shape;

public class Rectangle extends Shape {
	 
   public Rectangle(){
     type = "Rectangle";
   }
	 
   @Override
   public void draw() {
      System.out.println("Inside Rectangle::draw() method.");
   }
}
