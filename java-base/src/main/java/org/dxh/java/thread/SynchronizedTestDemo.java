package org.dxh.java.thread;

public class SynchronizedTestDemo {
	
	public static volatile double doubleNum = 1;
	
	 public synchronized void plusNumber() {
	       doubleNum++;
	 }
	 
	 public void minusNumber() {
	       synchronized (this) {
	          doubleNum--;
	       }
	 }
	
	 public synchronized static void divide() {
		doubleNum =doubleNum / 0.1;
	 }
	 
	 public static void main(String[] arg)throws Exception{
		 SynchronizedTestDemo synchronizedTestDemo = new SynchronizedTestDemo();
		 
		 TestThread testThread = new TestThread(synchronizedTestDemo);
		 
		 for(int i=0;i<10;i++) {
			 Thread thread = new Thread(testThread);
			 thread.start();
		 }
		 
	 }
}

class TestThread  implements Runnable{
	private SynchronizedTestDemo synchronizedTestDemo;
	public TestThread(SynchronizedTestDemo synchronizedTestDemo) {
		this.synchronizedTestDemo = synchronizedTestDemo;
	}

	public void run() {
		try {
			for(int i=0;i<20;i++) {
				synchronizedTestDemo.plusNumber();
				System.out.println("a = " + synchronizedTestDemo.doubleNum);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
