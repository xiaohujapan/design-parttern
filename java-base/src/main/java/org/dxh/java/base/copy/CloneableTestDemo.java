package org.dxh.java.base.copy;

public class CloneableTestDemo {

	public static void main(String[] args)throws Exception {
		Test test1 = new Test("original data");
		StringBuffer strBuf = new StringBuffer("origin data");
		
		CloneableClass org = new CloneableClass(test1, 1.0, "original", strBuf);
		CloneableClass copy = null;
		Object objTemp = org.clone();
		if (objTemp instanceof CloneableClass) {
	          copy = (CloneableClass)objTemp;
	    }
		
		System.out.println("copy == original? " + (copy == org));
	    System.out.println();
	    System.out.println("data of original:");
	    org.show();
	    System.out.println();
	    System.out.println("data of copy:");
	    copy.show();
	 
	    System.out.println();
	    System.out.println("org.data1 == copy.data1? " + (org.data1 == copy.data1));
	    System.out.println("org.data2 == copy.data2? " + (org.data2 == copy.data2));
	    System.out.println("org.data3 == copy.data3? " + (org.data3 == copy.data3));
	    System.out.println("org.data4 == copy.data4? " + (org.data4 == copy.data4));
	    
	    copy.data1.userData = "Copy data";
        copy.data2 = 2.0;
        copy.data3 = "Copy";
        copy.data4.replace(0, copy.data4.length(), "Copy data");
        
        System.out.println();
        System.out.println("After modify, data of original:");
        org.show();
        System.out.println();
        System.out.println("After modify, data of copy:");
        copy.show();
	}
}

class CloneableClass implements Cloneable{
	
	 public Test         data1 = null;
	 public double       data2 = 0;
	 public String       data3 = null;
	 public StringBuffer data4 = null;
	        
	 public CloneableClass(Test data1, double data2, String data3, StringBuffer data4) {
	        this.data1 = data1;
	        this.data2 = data2;
	        this.data3 = data3;
	        this.data4 = data4;
	  }
	
	 /**
	  * 用于显示对象中各字段的值
	  */
	 public void show() {
	      System.out.println("data1 = " + data1.userData);
	      System.out.println("data2 = " + data2);
	      System.out.println("data3 = " + data3);
	      System.out.println("data4 = " + data4);     
	 }

	 /**
	   * 重写clone()方法为public类型，并调用Object的本地clone()方法，实现浅拷贝功能
	   */
	 @Override
	 public Object clone() throws CloneNotSupportedException {
	      return super.clone();
	 }
}


class Test{
	public String userData = null;
	
	public Test(String userData) {
		this.userData = userData;
	}
}
