package org.dxh.java.thread.lession;


/**
 * 
 * 停止线程的机制
 * 由于stopped已经标记为volatile，每条线程都会访问主存中该变量而不会访问缓存中的拷贝
 * 只有在可见性问题时，才应该使用volatile，只能在属性声明出使用这个保留字
 * 避免在32位的JVM上面将double和long属性使用volatile，因为此时访问double和long的变量值需要进行2步操作，
 * 若要安全的访问他们的值，互斥是必要的
 */
public class LessionTwo4 {

	public static void main(String[] args) {
		class StoppableThread extends Thread{
			private volatile boolean stopped;
			
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
