package org.dxh.java.basespring.ioc.simple;

/*
 * IOC 测试使用的 bean
 */
public class Wheel {
    private String brand;
    private String specification;
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
}
