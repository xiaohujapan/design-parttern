package org.dxh.java.thread;

public class SleepAndWaitTestDemo {

	public static void main(String[] args) {
		new Thread(new WaitThread()).start();
		
		try {
			Thread.sleep(5000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		new Thread(new SleepThread()).start();
	}
	

	private static  class WaitThread implements Runnable{
		@Override
		public void run() {
			synchronized(SleepAndWaitTestDemo.class) {
				System.out.println("enter WaitThread..."); 
				System.out.println("WaitThread is waiting...");
				try {
					 //调用wait()方法，线程会放弃对象锁，进入等待此对象的等待锁定池
					SleepAndWaitTestDemo.class.wait();
				}catch(Exception e) {
					e.printStackTrace();
				}
				System.out.println("WaitThread is going on ....");
				System.out.println("WaitThread is over!!!");
			}	
		}
	}
	
	private static class SleepThread implements Runnable{
		@Override
		public void run() {
			synchronized(SleepAndWaitTestDemo.class) {
				System.out.println("enter SleepThread..."); 
				System.out.println("SleepThread is waiting...");
				//只有针对此对象调用notify()方法后本线程才进入对象锁定池准备获取对象锁进入运行状态。
				SleepAndWaitTestDemo.class.notify();
				//==================
			    //区别
				//如果我们把代码：SleepAndWaitTestDemo.class.notify();给注释掉，即SleepAndWaitTestDemo.class调用了wait()方法，但是没有调用notify()
				 //方法，则线程永远处于挂起状态。
				try {
					//sleep()方法导致了程序暂停执行指定的时间，让出cpu该其他线程，
					//但是他的监控状态依然保持者，当指定的时间到了又会自动恢复运行状态。
					//在调用sleep()方法的过程中，线程不会释放对象锁。
					Thread.sleep(5000);
				}catch(Exception e) {
					e.printStackTrace();
				}
				System.out.println("SleepThread is going on ....");
				System.out.println("SleepThread is over!!!");
			}
		}
	}
}

