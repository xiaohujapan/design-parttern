package org.dxh.java.thread.lession;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/***
 * 线程池框架Executor
 * 1.通过调用Executors的newFixedThreadPool方法获取一个executor。
 * 2.初始化了一个实现了callable接口的匿名类并且将这个任务提交给executor，在返回中接受一个Future的实例
 * 3.在提交任务以后，线程通常会做一些其他工作直到它获取此项任务的结果
 * 主线程在该Future的实例的isDone()方法返回true之前，不断地打印一条等待中的消息以模拟这种工作
 * 4·。主线程调用实例的get()方法来获取结果，稍后才会输出该结果。
 * 5.主程序关闭这个executor。
 */
public class LessionFive1 {
	final static int LASTITER = 17;

	public static void main(String[] args) {
		//ExecutorService是一个接口，ExecutorService接口继承了Executor接口，定义了一些生命周期的方法。
		/**
		 * 1.newFixedThreadPool创建一个可重用固定线程数的线程池，以共享的无界队列方式来运行这些线程。
		 * 2.newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程
		 * 3.newScheduledThreadPool创建一个定长线程池，支持定时及周期性任务执行
		 * 4.newSingleThreadExecutor创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
		 */
		ExecutorService executor 		= Executors.newFixedThreadPool(1);
		
		/**
		 * 不同于Runnable的void run()方法既不能返回值也不能抛出受检异常，
		 * Callable的V call()方法不仅可以返回值还可以抛出受检的异常
		 */
		Callable<BigDecimal> callable;	
		
		callable = new Callable<BigDecimal>() {
			public BigDecimal call() {
				MathContext mc = new MathContext(100,RoundingMode.HALF_UP);
				BigDecimal result = BigDecimal.ZERO;
				for(int i=0; i<= LASTITER; i++) {
					BigDecimal factorial = factorial(new BigDecimal(i));
					BigDecimal res = BigDecimal.ONE.divide(factorial, mc);
					result = result.add(res);
				}
				return result;
			}
			
			public BigDecimal factorial(BigDecimal n) {
				if(n.equals(BigDecimal.ZERO)) {
					return BigDecimal.ONE;
				}else {
					return n.multiply(factorial(n.subtract(BigDecimal.ONE)));
				}
			}	
		};
		
		/**
		 * Futrue的泛型是Futrue<V>,它提供了取消任务，返回任务的结果以及判断任务是否已经结束的方法
		 * 
		 */
		Future<BigDecimal> taskFuture = executor.submit(callable);
		try {
			System.out.println("task start！");
			while(!taskFuture.isDone()) {
				System.out.println("waiting");
			}
			System.out.println(taskFuture.get());
		}catch(ExecutionException ee) {
			System.err.println("task threw an exception");
			System.err.println(ee);
		}catch(InterruptedException ie) {
			System.err.println("interrupted while waiting");
		}
		executor.shutdownNow();
	}

}
