package org.dxh.java.thread.lession;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


/***
 * 
 * 1.主线程首先创建了一个浮点数矩阵并把这个矩阵导出到标准输出流当中。
 * 2.主程序初始化了类Solver，这个类为每一行分别创建了一条线程进行计算，更改之后的矩阵随后也被导出
 *
 */
public class LessionSix2 {

	public static void main(String[] args) {
		float[][] matrix = new float[3][3];
		int counter = 0;
		for(int row=0;row<matrix.length;row++) {
			for(int col=0;col<matrix[0].length;col++) {
				matrix[row][col] = counter++;
			}
		}
		dump(matrix);
		System.out.println();
		Solver solver = new Solver(matrix);
		System.out.println();
		dump(matrix);
	}
	
	static void dump(float[][] matrix) {
		for(int row=0;row<matrix.length;row++) {
			for(int col=0;col<matrix[0].length;col++) {
				System.out.println(matrix[row][col] + " ");
			}
			System.out.println();
		}
	}
}

/**
 * 
 * 1.Solver提供了一个构造函数，它接受矩阵参数并用属性data指向这个矩阵，同时用属性N指向矩阵行的数目。
 * 2.这个构造函数之后创建了一个拥有N条线的同步屏障，并且又负责把所有的行合并到矩阵。
 * 3.该构造函数分别创建工作线程，负责处理矩阵中单一的行。
 * 4.之后构造函数等待所有工作线程结束。
 *
 */
class Solver{
	final int N;
	final float[][] data;
	final CyclicBarrier barrier;
	
	class Worker implements Runnable{
		int myRow;
		boolean done = false;
		
		Worker(int row){
			myRow = row;
		}
		
		boolean done() {
			return done;
		}
		
		void processRow(int myRow) {
			System.out.println("Processing row: " + myRow);
			for(int i=0;i<N;i++) {
				data[myRow][i] *=10;
			}
			done = true;
		}
		
		public void run() {
			while(!done()) {
				processRow(myRow);
				try {
					barrier.await();
				}catch(InterruptedException ie) {
					return;
				}catch(BrokenBarrierException bbe) {
					return;
				}
			}
		}
	}
	
	
	public Solver(float[][] matrix) {
		data = matrix;
		N = matrix.length;
		barrier = new CyclicBarrier(N,new Runnable() {
			public void run() {
				mergeRows();
			}
		});
		for(int i=0;i<N;++i) {
			new Thread(new Worker(i)).start();
		}
		waitUntilDone();
	}
	
	void mergeRows() {
		System.out.println("merging");
		synchronized("abc") {
			"abc".notify();
		}
	}
	
	void waitUntilDone() {
		synchronized("abc") {
			try {
				System.out.println("main thread waiting");
				"abc".wait();
				System.out.println("main thread notified");
			}catch(InterruptedException ie) {
				System.out.println("main thread interrupted");
			}
		}
	}
	
}