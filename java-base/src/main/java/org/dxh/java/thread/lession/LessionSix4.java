package org.dxh.java.thread.lession;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 
 * 使用计数信号量去控制对一组条目的访问
 * 1.主程序创建了一个资源池，一个反复获取和归还资源的Runnable和一组executors，每个执行者都会执行这一Runnable
 * 2.类Pool的String getItem()以及void putItem(String item) 方法获取和归还基于字符串的资源。
 * 3.在通过getItem()获取一个条目之前，调用线程必须从信号量中获取一个许可证，这样才能保证这个条目可用。
 * 4.但线程处理完这个条目，他就会去调用putItem(String)方法，该方法会将此条目归还到池中，之后会释放一个只能够对这个信号量的许可证。
 * 5.当acquire()方法被调用的时候并不会持有同步锁，因为这样会阻止条目被归还到池中，不过String getNextAvailableItem() 
 * 和 markAsUnused(String item)方法会同步的去维持池的一致性。
 *
 */
public class LessionSix4 {

	public static void main(String[] args) {
		final Pool pool = new Pool();
		Runnable r = new Runnable() {
			public void run() {
				String name = Thread.currentThread().getName();
				try {
					while(true) {
						String item;
						System.out.println(name + " acquiring " + (item = pool.getItem()));
						Thread.sleep(200 + (int)(Math.random()*100));
						System.out.println(name + "putting back " + item) ;
						pool.putItem(item);
					}
				}catch(InterruptedException ie) {
					System.out.println(name + "interrupted");
				}
				
			}
		};
		ExecutorService[] executors = new ExecutorService[Pool.MAX_AVAILABLE + 1];
		for(int i=0;i<executors.length;i++) {
			executors[i] = Executors.newSingleThreadExecutor();
			executors[i].execute(r);
		}

	}
}
	
final class Pool{
	public static final int MAX_AVAILABLE = 10;
		
	private final Semaphore available = new Semaphore(MAX_AVAILABLE,true);
		
	private final String[] items;
		
	private final boolean[] used = new boolean[MAX_AVAILABLE];
		
	Pool() {
		items = new String[MAX_AVAILABLE];
		for(int i=0;i<items.length;i++) {
			items[i] = "I" + i;
		}
	}
		
	String getItem() throws InterruptedException{
		available.acquire();
		return getNextAvailableItem();
	}
		
	void putItem(String item) {
		if(markAsUnused(item)) {
			available.release();
		}
	}
		
	private synchronized String getNextAvailableItem() {
		for(int i=0;i<MAX_AVAILABLE;++i) {
			if(!used[i]) {
				used[i] = true;
				return items[i];
			}
		}
		return null;
	}
		
	private synchronized boolean markAsUnused(String item) {
		for(int i=0;i<MAX_AVAILABLE;++i) {
			if(item == items[i]) {
				if(used[i]) {
					used[i] = false;
					return true;
				}else {
					return false;
				}
			}
		}
		return false;
	}	
}

