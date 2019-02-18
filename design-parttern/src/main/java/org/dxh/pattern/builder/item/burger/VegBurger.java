package org.dxh.pattern.builder.item.burger;

import org.dxh.pattern.builder.item.Burger;

public class VegBurger extends Burger {
	 
	   @Override
	   public float price() {
	      return 25.0f;
	   }
	 
	   @Override
	   public String name() {
	      return "Veg Burger";
	   }
}
