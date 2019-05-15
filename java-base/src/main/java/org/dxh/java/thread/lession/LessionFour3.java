package org.dxh.java.thread.lession;

/**
 * 为不同的线程关联不同的用户ID
 * 初始化ThreadLocal并将引用赋值给一个volatile的类属性userID之后，
 * 默认的住线程创建了2条线程，分别在userID中存储了不同的java.lang.String对象并随后打印出这些对象
 *
 */
public class LessionFour3 {
	private static volatile ThreadLocal<String> userID = new ThreadLocal<String>();
	
	public static void main(String[] args) {
		Runnable r = new Runnable() {
			public void run() {
				String name = Thread.currentThread().getName();
				if(name.equals("A")) {
					userID.set("foxtrot");
				}else {
					userID.set("charlie");
				}
				System.out.println(name + " " + userID.get());
			}
		};
		Thread thdA = new Thread(r);
		thdA.setName("A");
		Thread thdB = new Thread(r);
		thdB.setName("B");
		thdA.start();
		thdB.start();
		
	}

}
