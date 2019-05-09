package org.dxh.java.thread.lession;

/**
 * 
 * 停止线程的机制
 * 当在单处理器单核的机器上运行程序时，会观测到程序停止。
 * 但是在一个多处理器或者是多核处理器的机器上可能就看不到程序停止，因为每个处理器都有一份自己的stopped的拷贝
 * 当一条线程修改了自己的拷贝，其他线程的拷贝并没有被改变
 */
public class LessionTwo2 {

	public static void main(String[] args) {
		class StoppableThread extends Thread{
			private boolean stopped;
			
			public void run() {
				while(!stopped) {
					System.out.println("running");
				}
			}
			
			void stopThread() {
				stopped = true;
			}
		}
		StoppableThread thd = new StoppableThread();
		thd.start();
		try {
			Thread.sleep(1000);
		}catch(InterruptedException ie) {
		}
		thd.stopThread();
	}
}
