package org.dxh.java.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class CasTestDemo {
	
	public static AtomicInteger race = new AtomicInteger(0);
	
	public static void increase() {
		race.getAndIncrement();
	}

	public static void main(String[] args) {
		for(int i= 0;i<20;i++) {
			Thread thread = new Thread(new Runnable() {
				public void run() {
					for(int j=0;j<10000;j++) {
						increase();
					}
				}
			});
			thread.start();
		}
		while(Thread.activeCount() > 1) {
			Thread.yield();
		}
		System.out.println(race);
	}

}
