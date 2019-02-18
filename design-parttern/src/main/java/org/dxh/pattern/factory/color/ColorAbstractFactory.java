package org.dxh.pattern.factory.color;

import org.dxh.pattern.factory.AbstractFactory;
import org.dxh.pattern.factory.Shape.Shape;

public class ColorAbstractFactory extends AbstractFactory {

	@Override
	public Color getColor(String color) {
	   if(color == null){
	      return null;
	   }        
	   if(color.equalsIgnoreCase("RED")){
	      return new Red();
	   } else if(color.equalsIgnoreCase("GREEN")){
	      return new Green();
	   } else if(color.equalsIgnoreCase("BLUE")){
	      return new Blue();
	   }
	   return null;
	}

	@Override
	public Shape getShape(String shape) {
		// TODO Auto-generated method stub
		return null;
	}

}
