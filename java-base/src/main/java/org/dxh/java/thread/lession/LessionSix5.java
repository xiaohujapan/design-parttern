package org.dxh.java.thread.lession;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

/**
 * 
 * 使用一个Phaser来控制一个一次性的动作，该动作作用于可变数量的线程上
 * 
 *
 */
public class LessionSix5 {

	public static void main(String[] args) {
		List<Runnable> tasks = new ArrayList<>();
		tasks.add(()->System.out.printf("%s running at %d%n",Thread.currentThread().getName(), System.currentTimeMillis()));
		
		tasks.add(()->System.out.printf("%s running at %d%n",Thread.currentThread().getName(), System.currentTimeMillis()));
		
		runTasks(tasks);
	}
	
	static void runTasks(List<Runnable> tasks) {
		final Phaser phaser = new Phaser(1);
		for(final Runnable task:tasks) {
			phaser.register();
			Runnable r = ()->{
				try {
					Thread.sleep(50 + (int)(Math.random()*300));
				}catch(InterruptedException ie) {
					System.out.println("interrupted thread");
				}
				phaser.arriveAndAwaitAdvance();
				task.run();
			};
			Executors.newSingleThreadExecutor().execute(r);
		}
		phaser.arriveAndDeregister();
		
	}
}
