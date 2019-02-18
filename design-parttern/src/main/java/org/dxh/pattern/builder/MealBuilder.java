package org.dxh.pattern.builder;

import org.dxh.pattern.builder.item.burger.ChickenBurger;
import org.dxh.pattern.builder.item.burger.VegBurger;
import org.dxh.pattern.builder.item.colddrink.Coke;
import org.dxh.pattern.builder.item.colddrink.Pepsi;

public class MealBuilder {

	public Meal prepareVegMeal (){
	    Meal meal = new Meal();
	    meal.addItem(new VegBurger());
	    meal.addItem(new Coke());
	    return meal;
	}   
		 
	public Meal prepareNonVegMeal (){
	   Meal meal = new Meal();
	    meal.addItem(new ChickenBurger());
	    meal.addItem(new Pepsi());
	    return meal;
	}
}
