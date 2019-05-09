package org.dxh.java.thread.lession;

/**
 * 一个死锁的例子
 *  　1.线程A调用instantceMethod1() ，获取到lock1引用对象的锁，然后进入它外部的临界区
 *    2.线程B调用instantceMethod2()，获取lock2 引用对象的锁，然后进入它外部的临界区
 *    3.线程A尝试去获取和lock2相关联的锁，JVM强制线程在内部临界区之外等待，由于线程B持有那个锁
 *    4.线程B尝试去获取和lock1相关联的锁，JVM强制线程在内部临界区之外等待，由于线程B持有那个锁
 *    5.由于其他线程持有了必要的锁，没有一条线程能继续执行，遭遇死锁，程序被冻住了
 *    
 */
public class LessionTwo1 {
	private final Object lock1 = new Object();
	private final Object lock2 = new Object();
	
	public void instantceMethod1() {
		synchronized(lock1){
			synchronized(lock2) {
				System.out.println("firse thread in instanceMethod1");
			}
		}
	}
	
	public void instantceMethod2() {
		synchronized(lock2){
			synchronized(lock1) {
				System.out.println("firse thread in instanceMethod2");
			}
		}
	}
	
	public static void main(String[] args) {
		final LessionTwo1 ltd = new LessionTwo1();
		Runnable r1 = new Runnable() {
			public void run() {
				while(true) {
					ltd.instantceMethod1();
					try {
						Thread.sleep(50);
					}catch(InterruptedException ie) {	
					}
				}
			}
		};
		Thread thdA = new Thread(r1);
		Runnable r2 = new Runnable() {
			public void run() {
				while(true) {
					ltd.instantceMethod2();
					try {
						Thread.sleep(50);
					}catch(InterruptedException ie) {	
					}
				}
			}
		};
		Thread thdB = new Thread(r2);
		thdA.start();
		thdB.start();
	}

}
