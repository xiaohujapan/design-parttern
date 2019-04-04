package org.dxh.java.base.other;

public class finalTest {
	
	public final static String TEST_VALUE = "final_test";

	public static void main(String[] args) {
		
		System.out.println("return value of test()]" + finallyNotDoTest());
	}

	public static int finallyNotDoTest() {
		int i=1;
		try{
			System.out.println("try block");
			System.exit(0);
			return i;
		}finally{
			System.out.println("finally block");
		}
	}
	
	
}
