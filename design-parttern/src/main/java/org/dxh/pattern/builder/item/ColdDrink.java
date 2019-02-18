package org.dxh.pattern.builder.item;

import org.dxh.pattern.builder.pack.Bottle;
import org.dxh.pattern.builder.pack.Packing;

public abstract class ColdDrink implements Item {
	@Override
	public Packing packing() {
		return new Bottle();
	}

	@Override
	public abstract float price();
}
