package org.dxh.java.thread.lession;

/**
 * 
 *  这个应用程序创建了一个共享对象，两条线程各自获取了该对象的一份拷贝。
 *  生产者调用这个对象的setSharedChar()方法来保存26个大写的英文字母
 *  消费者则调用该对象的getSharedChar() 方法来获取每个字母。
 *  writeable实例变量跟踪了2个条件：生产者等待消费者消费一个数据项和消费者等待生产者生产一个新数据项。它帮助协调生产者和消费者的执行
 *  1.消费者执行s.getSharedChar();
 *  2.在那个同步方法中，由于writeable变量是true，所以消费者调用了wait（）方法。消费者会一直等待，知道收到生产者的通知
 *  3.生产者最终执行了s.setSharedChar(ch);方法
 *  4.当生产者进入同步方法中，它发现writeable的值是true，便不会调用wait()方法。
 *  5.生产者保存下这个字母，把writeable的值设成false，并且用notify（）方法去唤醒消费者·。
 *  6.·生产者推出setSharedChar(char c)方法
 *  7.消费者醒来，把writeable变量是true，通知唤醒生产者线程能够，并返回共享的字母。
 *  
 */
public class LessionThree2 {

	public static void main(String[] args) {
		Shared2 s = new Shared2();
		new Producer2(s).start();
		new Consumer2(s).start();
	}

}

class Shared2{
	private char c;
	private volatile boolean writeable = true;
	
	synchronized void setSharedChar(char c) {
		while(!writeable) {
			try {
				wait();
			}catch(InterruptedException ie) {
			}
		}
		this.c =c;
		writeable = false;
		notify();
	}
	
	synchronized char getSharedChar() {
		while(writeable) {
			try {
				wait();
			}catch(InterruptedException ie) {
			}
		}
		writeable = true;
		notify();
		return c;
	}
}

class Producer2 extends Thread{
	private final Shared2 s;
	
	Producer2(Shared2 s){
		this.s= s;
	}
	
	public void run() {
		for(char ch='A';ch<='Z';ch++) {
			synchronized(s) {
				s.setSharedChar(ch);
				System.out.println(ch + " produced by producer.");
			}
		}
	}
}

class Consumer2 extends Thread{
	private final Shared2 s;
	
	Consumer2(Shared2 s){
		this.s= s;
	}
	
	public void run() {
		char ch;
		do {
			synchronized(s) {
				ch = s.getSharedChar();
				System.out.println(ch + " consumed by consumer. ");
			}
		}while(ch != 'Z');
	}
}