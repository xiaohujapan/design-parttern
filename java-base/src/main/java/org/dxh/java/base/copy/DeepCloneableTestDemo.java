package org.dxh.java.base.copy;

public class DeepCloneableTestDemo {

	public static void main(String[] args) throws Exception {
		Test test1 = new Test("original");
        StringBuffer strBuf = new StringBuffer("original");
        
        DeepCloneableClass org = new DeepCloneableClass(test1, 1.0, "original", strBuf);
        DeepCloneableClass copy = null;
        Object objTemp = org.clone();
        if (objTemp instanceof DeepCloneableClass) {
            copy = (DeepCloneableClass)objTemp;
        }// if
        
        System.out.println("Before modify, data of original:");
        org.show();
        System.out.println();
        System.out.println("Before modify, data of copy:");
        copy.show();
        
        // 判断两个对象中的引用型字段是否指向了同一个对象实例。
        System.out.println();
        System.out.println("org.data1 == copy.data1? " + (org.data1 == copy.data1));
        System.out.println("org.data2 == copy.data2? " + (org.data2 == copy.data2));
        System.out.println("org.data3 == copy.data3? " + (org.data3 == copy.data3));
        System.out.println("org.data4 == copy.data4? " + (org.data4 == copy.data4));
        
        // 修改copy中各字段指向对象的属性
        copy.data1.userData = "Copy";
        copy.data2 = 2.0;
        copy.data3 = "Copy";
        copy.data4.replace(0, copy.data4.length(), "Copy");
 
        System.out.println();
        System.out.println("After modify, data of original:");
        org.show();
        System.out.println();
        System.out.println("After modify, data of copy:");
        copy.show();

	}

}


class DeepCloneableClass implements Cloneable{
	
	 public Test         data1 = null;
	 public double       data2 = 0;
	 public String       data3 = null;
	 public StringBuffer data4 = null;
	        
	 public DeepCloneableClass(Test data1, double data2, String data3, StringBuffer data4) {
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
	  * 重写clone()方法为public类型，对每一个字段都创建一个新的对象，并将原字段指向对象中的属性
	  * 复制到新的对象中，从而实现深拷贝功能。
	  */
	 @Override
	 public Object clone() throws CloneNotSupportedException {
		 Test data1 = new Test(this.data1.userData);
		 double data2 = this.data2;
		 String data3 = new String(this.data3);
		 StringBuffer data4 = new StringBuffer(this.data4.toString());
		 
		 DeepCloneableClass copy = new DeepCloneableClass(data1, data2, data3, data4);
		 
		 return copy;
	 }
}