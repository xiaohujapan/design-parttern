package org.dxh.pattern.prototype.shape;

import org.dxh.pattern.prototype.Shape;

public class Circle extends Shape {
	 public Circle(){
	    type = "Square";
	  }
		 
	 @Override
	 public void draw() {
	     System.out.println("Inside Square::draw() method.");
	 }
}
