package org.dxh.pattern.prototype;


/**
 * 创建一个实现了 Cloneable 接口的抽象类。
 * 
 * @author xiaohujapan
 * @since 8.0
 */
public abstract class Shape implements Cloneable {
	private String id;
	protected String type;
	   
	public abstract void draw();
	   
	public String getType(){
	    return type;
	}
	   
	public String getId() {
	    return id;
	}
	   
	public void setId(String id) {
	   this.id = id;
	}
	   
	public Object clone() {
	   Object clone = null;
	   try {
	       clone = super.clone();
	   } catch (CloneNotSupportedException e) {
	       e.printStackTrace();
	   }
	   return clone;
	}
}
