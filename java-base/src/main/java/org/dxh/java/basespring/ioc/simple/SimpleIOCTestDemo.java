package org.dxh.java.basespring.ioc.simple;

/**
 * IOC 的测试类
 *
 */
public class SimpleIOCTestDemo {

	public static void main(String[] args)throws Exception {	
		String location = SimpleIOC.class.getResource("ioc-test.xml").getFile();
		
		SimpleIOC bf = new SimpleIOC(location);
	    Wheel wheel = (Wheel) bf.getBean("wheel");
	    System.out.println(wheel.getBrand());
	    Car car = (Car) bf.getBean("car");
	    System.out.println(car.getName());

	}

}
