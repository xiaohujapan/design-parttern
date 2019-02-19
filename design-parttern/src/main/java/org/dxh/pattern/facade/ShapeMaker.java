package org.dxh.pattern.facade;

import org.dxh.pattern.factory.Shape.Circle;
import org.dxh.pattern.factory.Shape.Rectangle;
import org.dxh.pattern.factory.Shape.Shape;
import org.dxh.pattern.factory.Shape.Square;

public class ShapeMaker {
	   private Shape circle;
	   private Shape rectangle;
	   private Shape square;
	 
	   public ShapeMaker() {
	      circle = new Circle();
	      rectangle = new Rectangle();
	      square = new Square();
	   }
	 
	   public void drawCircle(){
	      circle.draw();
	   }
	   public void drawRectangle(){
	      rectangle.draw();
	   }
	   public void drawSquare(){
	      square.draw();
	   }
}
