package org.dxh.java.thread.lession;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/***
 * CountDownLatch是一个同步工具类，它允许一个或多个线程一直等待，直到其他线程的操作执行完后再执行
 * 1.主线程中首相创建了一对倒计时门闩
 *    startSignal门闩会在默认主线程就绪之前禁止任何工作线程执行
 *    doneSignal会使得默认主线程等待所有的工作线程全部结束执行
 * 2.默认主线程接下来创建一个带有run()方法的runnable，它会被后续创建的工作线程执行。
 *    run()方法首先输出一条消息，然后调用startSignal的await()方法，
 *    在继续执行之前会一直等待直到门闩的计数变成0
 *    继续输出一条表示工作正在进行的消息，并且挑一个随机的时间睡眠用于模拟正在做的工作
 *    run()调用了doneSignal的countDown()方法递减了门闩的计数，一旦计数到0，等待这个信号
 *    的默认主程序就会继续执行，关闭executor和中断应用程序
 * 3.创建好runnable之后，从包含NTHREADS条线程的线程池获取一个executor，然后再这个executor上连续调用NTHREADS次execute（）方法，
 *    依次把runnable传入线程池中，这一动作会启动线程运行run()方法。
 * 4.默认主线程输出一条消息并且通过睡眠1秒的方式模拟执行其他的工作，然后调用startSignal的countDown()方法使工作线程开始运行，
 *    再输出一条消息表示主线程正在做一些别的事情，接着调用doneSignal的await()方法，在它可以继续执行之前等待倒计时门闩的计数降到0
 *
 */
public class LessionSix1 {
	final static int NTHREADS = 3;

	public static void main(String[] args) {
		final CountDownLatch startSignal = new CountDownLatch(1);
		final CountDownLatch doneSignal = new CountDownLatch(NTHREADS);
		
		Runnable r = new Runnable() {
			public void run() {
				try{
					report(Thread.currentThread().getName() + " entered run()");
					startSignal.await();
					report(Thread.currentThread().getName() + " : doging work");
					Thread.sleep((int)(Math.random()*1000));
					doneSignal.countDown();
				}catch(InterruptedException ie) {
					System.err.println(ie);
				}
			}
			
			void report(String s) {
				System.out.println(System.currentTimeMillis() + ": " + Thread.currentThread() + ": " + s );
			}
		};
		
		ExecutorService executor = Executors.newFixedThreadPool(NTHREADS);
		for(int i=0;i< NTHREADS;i++) {
			executor.execute(r);
		}
		try {
			System.out.println("main thread doing something");
			Thread.sleep(1000);
			startSignal.countDown();
			System.out.println("main thread doing something else");
			doneSignal.await();
		}catch(InterruptedException ie) {
			System.err.println(ie);
		}

	}

}
