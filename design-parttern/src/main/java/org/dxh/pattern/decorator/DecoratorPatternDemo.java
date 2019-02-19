package org.dxh.pattern.decorator;

import org.dxh.pattern.decorator.shape.Circle;
import org.dxh.pattern.decorator.shape.Rectangle;
import org.dxh.pattern.decorator.shape.Shape;

public class DecoratorPatternDemo {

	public static void main(String[] args) {
	     Shape circle = new Circle();
	      
	     Shape redCircle = new RedShapeDecorator(new Circle());
	 
	     Shape redRectangle = new RedShapeDecorator(new Rectangle());
	     System.out.println("Circle with normal border");
	     circle.draw();
	 
	     System.out.println("\nCircle of red border");
	     redCircle.draw();
	 
	     System.out.println("\nRectangle of red border");
	     redRectangle.draw();
	}

}
