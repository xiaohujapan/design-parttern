package org.dxh.java.thread.lession;

/**
 * 
 *  　线程睡眠测试
 *
 */
public class LessionOne4 {

	public static void main(String[] args) {
		Runnable r = new Runnable() {
			public void run() {
				String name = Thread.currentThread().getName();
				int count = 0;
				while(!Thread.interrupted()) {
					System.out.println(name + ":" + count++);
				}
			}
		};
		
		Thread thdA = new Thread(r);
		Thread thdB = new Thread(r);
		thdA.start();
		thdB.start();
		try {
			Thread.sleep(500);
		}catch(InterruptedException ie) {
		}
		thdA.interrupt();
		thdB.interrupt();
	}

}
