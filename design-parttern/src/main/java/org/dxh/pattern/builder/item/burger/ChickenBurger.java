package org.dxh.pattern.builder.item.burger;

import org.dxh.pattern.builder.item.Burger;

public class ChickenBurger extends Burger {

	   @Override
	   public float price() {
	      return 50.5f;
	   }
	 
	   @Override
	   public String name() {
	      return "Chicken Burger";
	   }

}
