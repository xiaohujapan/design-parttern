package org.dxh.pattern.decorator;

import org.dxh.pattern.decorator.shape.Shape;
import org.dxh.pattern.decorator.shape.ShapeDecorator;

public class RedShapeDecorator extends ShapeDecorator {
	public RedShapeDecorator(Shape decoratedShape) {
		super(decoratedShape);
	}
	
	@Override
	public void draw() {
	   decoratedShape.draw();         
	   setRedBorder(decoratedShape);
	}
	 
	private void setRedBorder(Shape decoratedShape){
	    System.out.println("Border Color: Red");
	}
}
