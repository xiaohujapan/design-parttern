package org.dxh.pattern.prototype.shape;

import org.dxh.pattern.prototype.Shape;

public class Square extends Shape {
	 public Square(){
	    type = "Rectangle";
	  }
		 
	 @Override
	 public void draw() {
	     System.out.println("Inside Rectangle::draw() method.");
	 }
}
