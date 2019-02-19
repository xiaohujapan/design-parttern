package org.dxh.pattern.bridge;

import org.dxh.pattern.bridge.draw.GreenCircle;
import org.dxh.pattern.bridge.draw.RedCircle;

public class BridgePatternDemo {

	public static void main(String[] args) {
	     Shape redCircle = new Circle(100,100, 10, new RedCircle());
	     Shape greenCircle = new Circle(100,100, 10, new GreenCircle());
	 
	     redCircle.draw();
	     greenCircle.draw();
	}

}
