package org.dxh.pattern.builder.item.colddrink;

import org.dxh.pattern.builder.item.ColdDrink;

public class Pepsi extends ColdDrink {

	   @Override
	   public float price() {
	      return 35.0f;
	   }
	 
	   @Override
	   public String name() {
	      return "Pepsi";
	   }
}
