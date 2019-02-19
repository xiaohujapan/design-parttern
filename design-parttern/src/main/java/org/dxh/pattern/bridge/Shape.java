package org.dxh.pattern.bridge;

import org.dxh.pattern.bridge.draw.DrawAPI;

public abstract class Shape {
	  protected DrawAPI drawAPI;
	  protected Shape(DrawAPI drawAPI){
	     this.drawAPI = drawAPI;
	  }
	  public abstract void draw();  
}
