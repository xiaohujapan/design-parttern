package org.dxh.pattern.factory;

import org.dxh.pattern.factory.Shape.ShapeAbstractFactory;
import org.dxh.pattern.factory.color.ColorAbstractFactory;

public class FactoryProducer {
	public static AbstractFactory getFactory(String choice){
	   if(choice.equalsIgnoreCase("SHAPE")){
	      return new ShapeAbstractFactory();
	   } else if(choice.equalsIgnoreCase("COLOR")){
	      return new ColorAbstractFactory();
	   }
       return null;
	}
}
