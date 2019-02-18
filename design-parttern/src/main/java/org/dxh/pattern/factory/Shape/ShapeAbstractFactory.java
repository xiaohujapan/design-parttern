package org.dxh.pattern.factory.Shape;

import org.dxh.pattern.factory.AbstractFactory;
import org.dxh.pattern.factory.color.Color;

public class ShapeAbstractFactory extends AbstractFactory {

	@Override
	public Color getColor(String color) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shape getShape(String shape) {
	    if(shape == null){
	        return null;
	    }        
	    if(shape.equalsIgnoreCase("CIRCLE")){
	       return new Circle();
	    } else if(shape.equalsIgnoreCase("RECTANGLE")){
	       return new Rectangle();
	    } else if(shape.equalsIgnoreCase("SQUARE")){
	       return new Square();
	    }
	    return null;
	}

}
