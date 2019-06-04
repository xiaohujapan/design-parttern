package org.dxh.java.thread.lession.seven;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * 用重入锁获取同步功能
 * 1.主线程创建了一对工作线程，它们进入临界区，在其中模拟执行任务，然后离开临界区。
 * 2.使用了ReentrantLock的lock()和unlock()方法来获取和释放一个重入锁。
 * 3.当一条线程调用lock()方法而锁又不可用时，这个线程就会一直禁用，知道锁变为可用。
 *
 */
public class LessionSeven1 {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		/**
		 * ReentrantLock实现了lock的方法，对unlock()方法的实现在调用线程没有持有锁的情况下
		 * 会抛出java.lang.IllegalMonitorStateException
		 */
		final ReentrantLock lock = new ReentrantLock();
		
		class Worker implements Runnable{
			private final String name;
			
			Worker(String name){
				this.name = name;
			}
			
			public void run() {
				lock.lock();
				try {
					//boolean isHeldByCurrentThread（）方法在锁被当前线程持有的情况下，返回true.
					if(lock.isHeldByCurrentThread()) {
						System.out.printf("Thread %s entered critical section.%n", name);
					}
					System.out.printf("Thread %s performing work.%n", name);
					try {
						Thread.sleep(2000);
					}catch(InterruptedException ie) {
						ie.printStackTrace();
					}
					System.out.printf("Thread %s finished work.%n", name);
				}finally {
					lock.unlock();
				}
				
			}
			
		}
		executor.execute(new Worker("ThdA"));
		executor.execute(new Worker("ThdB"));
		try {
			executor.awaitTermination(5, TimeUnit.SECONDS);
		}catch(InterruptedException ie) {
			ie.printStackTrace();
		}
		executor.shutdownNow();
	}

}
